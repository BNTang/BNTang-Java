package top.it6666.core.convert;

import cn.hutool.core.date.Month;

import java.util.Calendar;

/**
 * @author BNTang
 * @version 1.0
 * @description 测试 HuTool 提供的日期工具
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
    // ========================================= 日期时间 =========================================

    public static void main(String[] args) {
        dateTimeMonthEnum();
    }
}