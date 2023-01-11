package top.it6666.core.convert;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;

import java.util.Calendar;
import java.util.Date;

/**
 * @author BNTang
 * @version 1.0
 * @description 测试 HuTool 提供的日期工具类
 * @since 2023-10-11
 **/
public class THuToolDate {

    // ========================================= 日期时间 =========================================

    /**
     * 月份枚举-通过月份枚举可以获得某个月的最后一天
     */
    public static void dateTimeMonthEnum() {
        // 31
        int lastDay = Month.of(Calendar.JANUARY).getLastDay(false);
        System.out.println("lastDay = " + lastDay);
    }

    /**
     * Date、long、Calendar之间的相互转换
     */
    public static void dateLongCalendarConvert() {
        //当前时间
        Date date = DateUtil.date();
        System.out.println("date = " + date);

        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        System.out.println("date2 = " + date2);

        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        System.out.println("date3 = " + date3);

        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        System.out.println("now = " + now);

        //当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();
        System.out.println("today = " + today);
    }

    /**
     * 字符串转日期
     */
    public static void stringConvertDate() {
        String dateStr = "2017-03-01";
        Date date = DateUtil.parse(dateStr);
        System.out.println("date = " + date);
    }

    /**
     * 自定义日期格式转化
     */
    public static void customDateFormatStringToDate() {
        String dateStr = "2017-03-01";
        Date date = DateUtil.parse(dateStr, "yyyy-MM-dd");
        System.out.println("date = " + date);
    }
    // ========================================= 日期时间 =========================================

    public static void main(String[] args) {
        dateTimeMonthEnum();
        dateLongCalendarConvert();
        stringConvertDate();
        customDateFormatStringToDate();
    }
}