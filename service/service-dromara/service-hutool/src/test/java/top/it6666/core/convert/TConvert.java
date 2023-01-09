package top.it6666.core.convert;

import cn.hutool.core.convert.Convert;

/**
 * @author BNTang
 * @version 1.0
 * @description
 * @since 2023-23-08
 **/
public class TConvert {
    public static void main(String[] args) {
        paramToString();
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
}