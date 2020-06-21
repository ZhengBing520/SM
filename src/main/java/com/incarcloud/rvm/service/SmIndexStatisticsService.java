package com.incarcloud.rvm.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.incarcloud.rvm.bean.DqStatistics2Bean;
import com.incarcloud.rvm.bean.DqStatisticsBean;
import com.incarcloud.rvm.jdbc.rowmapper.MyColumnMapRowMapper;
import com.incarcloud.rvm.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bzheng on 2020/5/18.
 */
@Service
public class SmIndexStatisticsService {

    private static Logger logger = LoggerFactory.getLogger(SmIndexStatisticsService.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("phoenixJdbcTemplate")
    JdbcTemplate phoenixJdbcTemplate;

    /**
     * 将Phoenix表的数据存到文件
     * @return
     */
    public boolean syncData(String date,String platCode, String filePath) {
        if (StringUtils.isBlank(date)) {
            throw new RuntimeException("时间不能为空");
        }
        // 1.查询数据
        List<DqStatisticsBean> dqStatisticsBeans = queryData(date, platCode);
        // 2.将数据存到文件
        if (StringUtils.isBlank(filePath)) {
            filePath = "/app/statistics.txt";
        }
        return dataToFile(dqStatisticsBeans, filePath);
    }

    private boolean dataToFile(List<DqStatisticsBean> dqStatisticsBeans, String fileName) {
        if (CollectionUtils.isEmpty(dqStatisticsBeans)) {
            logger.info("没有查到数据");
            return false;
        }
        logger.info("导出到文件：{}", fileName);
        // 判断文件是否存在
        Path path = Paths.get(fileName);
        try {
            Files.deleteIfExists(path);
            Files.createDirectories(path.getParent());
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2、获取文件流
        try (
                PrintWriter pw = new PrintWriter(new FileWriter(path.toFile(), true))
        ) {
            dqStatisticsBeans.forEach(bean -> {
                pw.println(JSON.toJSONString(bean));
            });
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 查询某段时间的数据
     * @param date
     * @return
     */
    private List<DqStatisticsBean> queryData(String date,String platCode) {
        // 查询Phoenix
        String sql = "select * from \"saic\".\"dq_statistics\"  where 1 = 1 and \"statisticsDate\" = ?  and \"platformCode\" = ?";
        List<Map<String, Object>> maps = phoenixJdbcTemplate.query(sql, MyColumnMapRowMapper.ROW_MAPPER, date, platCode);
        List<DqStatisticsBean> query = JSON.parseArray(JSON.toJSONString(maps), DqStatisticsBean.class);
//       phoenixJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(DqStatisticsBean.class), dateBegin, dateEnd, platCode);
        return query;
    }


    public boolean importFromExcel(MultipartFile file) {
        List<DqStatistics2Bean> list = readFile(file);
        // 先只写里程的

        return true;
    }

    private List<DqStatistics2Bean> readFile(MultipartFile file) {
        List<DqStatistics2Bean> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()));){
            String json;
            while (StringUtils.isNotBlank(json = bufferedReader.readLine())) {
                DqStatistics2Bean dqStatisticsBean = JSON.parseObject(json, DqStatistics2Bean.class);
                list.add(dqStatisticsBean);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
