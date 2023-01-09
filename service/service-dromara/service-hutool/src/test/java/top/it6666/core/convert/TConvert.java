package top.it6666.core.convert;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;

import java.util.Date;
import java.util.List;

/**
 * @author BNTang
 * @version 1.0
 * @description
 * @since 2023-23-08
 **/
public class TConvert {
    public static void main(String[] args) {
        // paramToString();
        // paramToArray();
        // paramToDate();
        // paramToList();
        // HalfAngleToFullAngle();
        // genericityConvert();
        fullAngleToHalfAngle();
    }

    public static void paramToString() {
        int a = 1;
        // aStr为"1"
        String aStr = Convert.toStr(a);
        System.out.println("aStr = " + aStr);

        long[] b = {1, 2, 3, 4, 5};
        // bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);
        System.out.println("b = " + b);
        System.out.println("bStr = " + bStr);
    }

    public static void paramToArray() {
        String[] b = {"1", "2", "3", "4"};
        //结果为Integer数组
        Integer[] intArray = Convert.toIntArray(b);
        System.out.println("intArray = " + intArray);

        long[] c = {1, 2, 3, 4, 5};
        //结果为Integer数组
        Integer[] intArray2 = Convert.toIntArray(c);
        System.out.println("intArray2 = " + intArray2);
    }

    public static void paramToDate() {
        String a = "2017-05-06";
        Date value = Convert.toDate(a);
        System.out.println("value = " + value);
    }

    public static void paramToList() {
        Object[] a = {"a", "你", "好", "", 1};
        List<?> list = Convert.convert(List.class, a);
        System.out.println("list = " + list);

        //从4.1.11开始可以这么用
        List<?> list2 = Convert.toList(a);
        System.out.println("list2 = " + list2);

        Student student = new Student();
        List<?> objects = Convert.toList(student);
        System.out.println(objects);
    }

    public static void genericityConvert() {
        Object[] a = {"a", "你", "好", "", 1};

        // result = list = [a, 你, 好, , 1]
        List<String> list = Convert.convert(new TypeReference<List<String>>() {
        }, a);

        System.out.println("list = " + list);
    }

    public static void halfAngleToFullAngle() {
        String a = "123456789";

        //结果为："１２３４５６７８９"
        String sbc = Convert.toSBC(a);
        System.out.println("sbc = " + sbc);
    }

    public static void fullAngleToHalfAngle() {
        String a = "１２３４５６７８９";

        //结果为"123456789"
        String dbc = Convert.toDBC(a);
        System.out.println("dbc = " + dbc);
    }

    public static void method(){

    }
}