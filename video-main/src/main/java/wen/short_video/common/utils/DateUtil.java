package wen.short_video.common.utils;


import org.springframework.stereotype.Component;

/**
 * 时间工具类
 */
@Component
public class DateUtil {
    //将Java date转化为 数据库Datepublic
    static java.sql.Timestamp javeTimeToDB(java.util.Date d) {
        if (null == d) return null;
        return new java.sql.Timestamp(d.getTime());


    }
}