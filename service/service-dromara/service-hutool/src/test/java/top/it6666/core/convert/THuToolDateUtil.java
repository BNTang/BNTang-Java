package top.it6666.core.convert;

import cn.hutool.core.date.*;
import cn.hutool.core.lang.Console;

import java.util.Calendar;
import java.util.Date;

/**
 * @author BNTang
 * @version 1.0
 * @description 测试 HuTool DateUtil
 * @since 2023-10-11
 **/
public class THuToolDateUtil {
    /**
     * Date、long、Calendar之间的相互转换
     */
    public static void dateLongCalendarConvert() {
        // 当前时间
        Date date = DateUtil.date();
        System.out.println("date = " + date);

        // 当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        System.out.println("date2 = " + date2);

        // 当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        System.out.println("date3 = " + date3);

        // 当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        System.out.println("now = " + now);

        // 当前日期字符串，格式：yyyy-MM-dd
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

    /**
     * 格式化日期输出
     */
    public static void formatDateOutPut() {
        String dateStr = "2017-03-01";
        Date date = DateUtil.parse(dateStr);

        // 结果 2017/03/01
        String format = DateUtil.format(date, "yyyy/MM/dd");
        System.out.println("format = " + format);

        // 常用格式的格式化，结果：2017-03-01
        String formatDate = DateUtil.formatDate(date);
        System.out.println("formatDate = " + formatDate);

        // 结果：2017-03-01 00:00:00
        String formatDateTime = DateUtil.formatDateTime(date);
        System.out.println("formatDateTime = " + formatDateTime);

        // 结果：00:00:00
        String formatTime = DateUtil.formatTime(date);
        System.out.println("formatTime = " + formatTime);
    }

    /**
     * 获取Date对象的某个部分
     */
    public static void getDatePart() {
        Date date = DateUtil.date();
        // 获得年的部分
        System.out.println("DateUtil.year(date) = " + DateUtil.year(date));

        // 获得月份，从0开始计数
        System.out.println("DateUtil.month(date) = " + DateUtil.month(date));

        // 获得月份枚举
        System.out.println("DateUtil.monthEnum(date) = " + DateUtil.monthEnum(date));
        // .....
    }

    /**
     * 开始和结束时间 *
     */
    public static void getDateStartAndEndTime() {
        String dateStr = "2017-03-01 22:33:23";
        Date date = DateUtil.parse(dateStr);

        // 一天的开始，结果：2017-03-01 00:00:00
        Date beginOfDay = DateUtil.beginOfDay(date);
        System.out.println("beginOfDay = " + beginOfDay);

        // 一天的结束，结果：2017-03-01 23:59:59
        Date endOfDay = DateUtil.endOfDay(date);
        System.out.println("endOfDay = " + endOfDay);
    }

    /**
     * 日期时间偏移
     */
    public static void dateTimeOffSet() {
        String dateStr = "2017-03-01 22:33:23";
        Date date = DateUtil.parse(dateStr);

        // 结果：2017-03-03 22:33:23
        Date newDate = DateUtil.offset(date, DateField.DAY_OF_MONTH, 2);
        System.out.println("newDate = " + newDate);

        // 常用偏移，结果：2017-03-04 22:33:23
        DateTime newDate2 = DateUtil.offsetDay(date, 3);
        System.out.println("newDate2 = " + newDate2);

        // 常用偏移，结果：2017-03-01 19:33:23
        DateTime newDate3 = DateUtil.offsetHour(date, -3);
        System.out.println("newDate3 = " + newDate3);
    }

    /**
     * 当前时间偏移方法
     */
    public static void currentDateOffSet() {
        // 昨天
        System.out.println("DateUtil.yesterday() = " + DateUtil.yesterday());

        // 明天
        System.out.println("DateUtil.tomorrow() = " + DateUtil.tomorrow());

        // 上周
        System.out.println("DateUtil.lastWeek() = " + DateUtil.lastWeek());

        // 下周
        System.out.println("DateUtil.nextWeek() = " + DateUtil.nextWeek());

        // 上个月
        System.out.println("DateUtil.lastMonth() = " + DateUtil.lastMonth());

        // 下个月
        System.out.println("DateUtil.nextMonth() = " + DateUtil.nextMonth());
    }

    /**
     * 日期时间差
     */
    public static void dateTimeDifference() {
        String dateStr1 = "2017-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);

        String dateStr2 = "2017-04-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr2);

        // 相差一个月，31天
        long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
        System.out.println("betweenDay = " + betweenDay);
    }

    /**
     * 格式化时间差
     */
    public static void formatTimeDifference() {
        String dateStr1 = "2017-03-01 22:33:23";
        Date date1 = DateUtil.parse(dateStr1);

        String dateStr2 = "2017-04-01 23:33:23";
        Date date2 = DateUtil.parse(dateStr2);

        long between = DateUtil.betweenMs(date1, date2);

        // Level.MINUTE表示精确到分
        String formatBetween = DateUtil.formatBetween(between, BetweenFormatter.Level.MINUTE);

        // 输出：31天1小时
        Console.log(formatBetween);
    }

    /**
     * 星座和属相
     */
    public static void constellationAndChineseZodiac() {
        // "双子座"
        String zodiac = DateUtil.getZodiac(Month.MAY.getValue(), 25);
        System.out.println("zodiac = " + zodiac);

        // "狗"
        String chineseZodiac = DateUtil.getChineseZodiac(2001);
        System.out.println("chineseZodiac = " + chineseZodiac);
    }

    /**
     * 其它
     */
    public static void other() {
        // 年龄
        System.out.println("DateUtil.ageOfNow(\"2001-05-25\") = " + DateUtil.ageOfNow("2001-05-25"));

        // 是否闰年
        System.out.println("DateUtil.isLeapYear(2023) = " + DateUtil.isLeapYear(2023));
    }

    public static void main(String[] args) {
        dateLongCalendarConvert();
        stringConvertDate();
        customDateFormatStringToDate();
        formatDateOutPut();
        getDatePart();
        getDateStartAndEndTime();
        dateTimeOffSet();
        currentDateOffSet();
        dateTimeDifference();
        formatTimeDifference();
        constellationAndChineseZodiac();
        other();
    }
}