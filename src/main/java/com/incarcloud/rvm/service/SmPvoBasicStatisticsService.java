package com.incarcloud.rvm.service;

import com.incarcloud.concurrent.LimitedSyncTask;
import com.incarcloud.rvm.bean.SmPvoBasicBean;
import com.incarcloud.rvm.bean.SmPvoBasicStatisticsBean;
import com.incarcloud.rvm.util.DateUtils;
import com.incarcloud.rvm.util.DecimalCalculate;
import com.incarcloud.rvm.util.TaskUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by bzheng on 2020/5/6.
 */
@Service
public class SmPvoBasicStatisticsService {

    private static Logger logger = LoggerFactory.getLogger(SmPvoBasicStatisticsService.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("phoenixJdbcTemplate")
    JdbcTemplate phoenixJdbcTemplate;

    @Value("${sm.rvm.queryTask:5}")
    int queryTask;

    @Value("${sm.rvm.batchSize:1000}")
    int batchSize;
    
    public Boolean syncData(Date timeBegin, Date timeEnd) {
        // 查数据
        List<SmPvoBasicStatisticsBean> data = queryData(timeBegin, timeEnd);
        // 转换数据
        List<SmPvoBasicBean> list = convert(data);
        // 先清空表
        removeAll();
        return batchInsert(list);
    }

    private void removeAll() {
        jdbcTemplate.update("truncate table sm_pvo_basic");
    }

    private List<SmPvoBasicBean> convert(List<SmPvoBasicStatisticsBean> data) {
        if (CollectionUtils.isEmpty(data)) {
            return Collections.emptyList();
        }
        // 通过Vin码分组
        Map<String, List<SmPvoBasicStatisticsBean>> collect = data.parallelStream().collect(Collectors.groupingBy(SmPvoBasicStatisticsBean::getVin));
        List<SmPvoBasicBean> list = new ArrayList<>(collect.size());
        // 求和
        collect.forEach((k,v) -> {
            SmPvoBasicBean bean = new SmPvoBasicBean();
            bean.setVin(k);
            bean.setVehicleModel(v.get(0).getVehicleModel());
            bean.setTotalDay(v.size());
            double totalMileage = v.stream().mapToDouble(SmPvoBasicStatisticsBean::getTodayMileage).sum();
            bean.setTotalMileage(totalMileage);
            double totalRuntime = v.stream().mapToDouble(SmPvoBasicStatisticsBean::getTodayRuntime).sum();
            // 秒转分
            double div = DecimalCalculate.div(totalRuntime, 60, 2);
            bean.setTotalRuntime(div);
            list.add(bean);
        });
        return list;
    }

    private boolean batchInsert(List<SmPvoBasicBean> list) {
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }
        String sql = "insert into sm_pvo_basic(vin,vehicle_model,total_day,total_runtime,total_mileage) values (?,?,?,?,?)";
        // 将list分批，一批1000
        int pageSize = list.size() % batchSize == 0 ? list.size() / batchSize : list.size() / batchSize + 1;
        for (int i = 1; i <= pageSize; i++) {
            if (i == pageSize) {
                try {
                    batchInsert(sql, list.subList((i - 1) * batchSize, list.size()));
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                    return false;
                }

            } else {
                try {
                    batchInsert(sql, list.subList((i - 1) * batchSize, i * batchSize));
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                    return false;
                }
            }
        }

        return true;
    }

    private void batchInsert(String sql, List<SmPvoBasicBean> list) {
        logger.info("数据插入表，数据量：{}", list.size());
        int[] ints = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                SmPvoBasicBean smPvoBasicBean = list.get(i);
                if (Objects.nonNull(smPvoBasicBean)) {
                    ps.setString(1, smPvoBasicBean.getVin());
                    ps.setString(2, smPvoBasicBean.getVehicleModel());
                    ps.setInt(3, smPvoBasicBean.getTotalDay());
                    ps.setDouble(4, smPvoBasicBean.getTotalRuntime());
                    ps.setDouble(5, smPvoBasicBean.getTotalMileage());
                }
            }

            @Override
            public int getBatchSize() {
                return list.size();
            }

        });

    }

    private List<SmPvoBasicStatisticsBean> queryData(Date timeBegin, Date timeEnd) {
        if (Objects.isNull(timeBegin) || Objects.isNull(timeEnd)) {
            throw new IllegalArgumentException("时间参数不能为null");
        }
        if (timeBegin.getTime() > timeEnd.getTime()) {
            throw new IllegalArgumentException("开始时间不能大于结束时间");
        }
        // 获取日期相差多少天
        int diff = (int) DateUtils.getDiff(timeBegin, timeEnd, ChronoUnit.DAYS);
        // 开始和结束都要算，所以要加一天
        CountDownLatch countDownLatch = new CountDownLatch(diff+1);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        LimitedSyncTask task = new LimitedSyncTask();
        task.setMax(queryTask);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            String log = TaskUtil.printMetric(task, 0, "queryTask");
            if (log != null) {
                logger.info("\n" + log);
            }
        }, 1, 10, TimeUnit.SECONDS);
        StringBuilder sb = new StringBuilder();
        sb.append(" select t1.\"vin\" as vin,t1.\"model\" as vehicleModel, to_number(t1.\"totalRunTime\") as \"todayRunTime\", " +
                " (to_number(t1.\"maxMileage\") - to_number(t1.\"minMileage\")) as todayMileage from \"saic\".\"PVO_BASIC\" t1 ");
        sb.append("  where 1 = 1 ");
        sb.append(" and  t1.\"reportTimeBegin\"  = ? ");
        // SQL语句
        String sql = sb.toString();
        try {
            return select(sql, diff, timeBegin, task, countDownLatch);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            scheduledExecutorService.shutdown();
        }
        return Collections.emptyList();
    }

    private List<SmPvoBasicStatisticsBean> select(String sql, int diff, Date timeBegin, LimitedSyncTask task, CountDownLatch countDownLatch) {
        List<SmPvoBasicStatisticsBean> data = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i <= diff; i++) {
            String day = DateUtils.formatDate(DateUtils.getPlusDay(timeBegin, i), "yyyyMMdd");
            task.submit(() -> {
                List<SmPvoBasicStatisticsBean> list = queryData(sql, day);
                logger.info("查询Phoenix表，返回数据量：{}，日期为：{}", list.size(), day);
                data.addAll(list);
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
        return data;
    }

    private List<SmPvoBasicStatisticsBean> queryData(String sql, String day) {
        List<SmPvoBasicStatisticsBean> query = phoenixJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SmPvoBasicStatisticsBean.class), day);
        if (CollectionUtils.isEmpty(query)) {
            return query;
        }
        // 加上规则

        return query.stream().filter(this::filter).collect(Collectors.toList());
    }

    /**
     * 过滤规则
     * @param smPvoBasicStatisticsBean
     * @return
     */
    private boolean filter(SmPvoBasicStatisticsBean smPvoBasicStatisticsBean) {
        if (Objects.isNull(smPvoBasicStatisticsBean)) {
            return false;
        }
        Double todayMileage = smPvoBasicStatisticsBean.getTodayMileage();
        if (Objects.isNull(todayMileage)) {
            return false;
        }
        // 单日行驶里程要求[0,5760]km
        if (0 > todayMileage || 5760 < todayMileage) {
            return false;
        }

        Double todayRuntime = smPvoBasicStatisticsBean.getTodayRuntime();
        if (Objects.isNull(todayRuntime)) {
            return false;
        }
        // 单日行驶时长[0,1440]min -> todayMileage的单位是秒 86,400‬
        if (0 > todayRuntime || 86400 < todayRuntime) {
            return false;
        }

        return true;
    }

}
