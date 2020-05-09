package com.incarcloud.rvm.util;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * Created by bzheng on 2020/4/28.
 */
public class DateUtils  {

    public final static String DATE_FORMAT_DAY="yyyy-MM-dd";
    public final static String DATE_FORMAT_SECOND="yyyy-MM-dd HH:mm:ss";
    public final static String DATE_FORMAT_MONTH="yyyy-MM";

    /**
     * 获取几天前/后的时间
     * @param n n > 0 后，n < 0 前
     * @return
     */
    public static Date getPlusDay(int n) {
        // 获取n天后的数据
        return getPlusDay(Calendar.DATE, n);
    }

    /**
     * 获取几天前/后的时间
     * @param n n > 0 后，n < 0 前
     * @return
     */
    public static Date getPlusDay(Date date, int n) {
        // 获取n天后的数据
        return getPlusDay(date, Calendar.DATE, n);
    }

    /**
     * 获取 n 个时间单位前后的时间
     * @param type
     * @see Calendar#DATE  {@link Calendar#MONTH,Calendar#SECOND }
     * @param n
     * @return
     */
    public static Date getPlusDay(int type, int n) {
        return getPlusDay(null, type, n);
    }

    public static long getDiff(Date d1, Date d2, ChronoUnit unit){
        return getDiff(d1, d2, unit,true);
    }

    /**
     * 计算两个时间相差多少日期单位(不足一个日期单位的的按一个日期单位算)
     * @param d1 开始时间
     * @param d2 结束时间
     * @param unit 支持ChronoUnit.MILLIS,ChronoUnit.SECONDS,ChronoUnit.MINUTES,ChronoUnit.HOURS,ChronoUnit.DAYS
     * @param up 如果存在小数位,是向上取整还是向下取整;true代表向上;false代表向下
     * @return 相差日期单位数
     */
    public static long getDiff(Date d1,Date d2,ChronoUnit unit,boolean up)
    {
        ChronoUnit[] units=new ChronoUnit[]{ChronoUnit.MILLIS,ChronoUnit.SECONDS,ChronoUnit.MINUTES,ChronoUnit.HOURS,ChronoUnit.DAYS, ChronoUnit.MONTHS};
        if(!Arrays.stream(units).anyMatch(e->e==unit)){
            throw new RuntimeException("[DateUtil.getDiff],ChronoUnit["+unit.toString()+"] Not Support!");
        }
        long diff;
        switch (unit){
            case DAYS:{
                diff=ChronoUnit.DAYS.getDuration().toMillis();
                break;
            }
            case HOURS:{
                diff=ChronoUnit.HOURS.getDuration().toMillis();
                break;
            }
            case MINUTES:{
                diff=ChronoUnit.MINUTES.getDuration().toMillis();
                break;
            }
            case SECONDS:{
                diff=ChronoUnit.SECONDS.getDuration().toMillis();
                break;
            }
            case MILLIS:{
                diff=ChronoUnit.MILLIS.getDuration().toMillis();
                break;
            }
            case MONTHS:{
                diff = ChronoUnit.MONTHS.getDuration().toMillis();
                break;
            }
            default:{
                throw new RuntimeException("[DateUtil.getDiff],ChronoUnit["+unit.toString()+"] Not Support!");
            }
        }
        long begin = d1.getTime();
        long end = d2.getTime();
        double res= (end-begin)/((double)diff);
        if(up){
            return (int)Math.ceil(res);
        }else{
            return (int)Math.floor(res);
        }
    }
    /**
     * 获取 n 个时间单位前后的时间
     * @param type
     * @see Calendar#DATE,Calendar#SECOND
     * @param n
     * @return
     */
    public static Date getPlusDay(Date date, int type, int n) {
        Calendar instance = Calendar.getInstance();
        if (Objects.nonNull(date)) {
            instance.setTime(date);
        }
        instance.add(type, n);
        // 获取n天后的数据
        return instance.getTime();
    }

    public static String formatDate(Date date, String format) {
        if (null != date) {
            DateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.format(date);
        }
        return null;
    }

    public static Date parseStr(String date, String format) {
        if (StringUtils.isNotBlank(date)) {
            DateFormat dateFormat = new SimpleDateFormat(format);
            try {
                return dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
