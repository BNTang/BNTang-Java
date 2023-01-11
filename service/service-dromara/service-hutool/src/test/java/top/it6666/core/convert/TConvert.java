package top.it6666.core.convert;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.Converter;
import cn.hutool.core.convert.ConverterRegistry;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.CharsetUtil;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author BNTang
 * @version 1.0
 * @description 测试类型转换
 * @since 2023-23-08
 **/
public class TConvert {
    /**
     * 转换为字符串
     */
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

    /**
     * 转换为指定类型数组
     */
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

    /**
     * 转换为日期对象
     */
    public static void paramToDate() {
        String a = "2017-05-06";
        Date value = Convert.toDate(a);
        System.out.println("value = " + value);
    }

    /**
     * 转换为集合
     */
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

    /**
     * 泛型类型转换
     */
    public static void genericityConvert() {
        Object[] a = {"a", "你", "好", "", 1};

        // result = list = [a, 你, 好, , 1]
        List<String> list = Convert.convert(new TypeReference<List<String>>() {
        }, a);

        System.out.println("list = " + list);
    }

    /**
     * 半角转换为全角
     */
    public static void halfAngleToFullAngle() {
        String a = "123456789";

        //结果为："１２３４５６７８９"
        String sbc = Convert.toSBC(a);
        System.out.println("sbc = " + sbc);
    }

    /**
     * 全角转换为半角
     */
    public static void fullAngleToHalfAngle() {
        String a = "１２３４５６７８９";

        //结果为"123456789"
        String dbc = Convert.toDBC(a);
        System.out.println("dbc = " + dbc);
    }

    /**
     * 转为16进制（Hex）字符串
     */
    public static void convertToSixTeenBase() {
        String a = "我是一个小小的可爱的字符串";

        //结果："e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2"
        String hex = Convert.toHex(a, CharsetUtil.CHARSET_UTF_8);
        System.out.println("hex = " + hex);
    }

    /**
     * 将16进制（Hex）字符串转为普通字符串
     */
    public static void convertSixTeenBaseToString() {
        String hex = "e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2";

        //结果为："我是一个小小的可爱的字符串"
        //String raw = Convert.hexStrToStr(hex, CharsetUtil.CHARSET_UTF_8);

        //注意：在4.1.11之后hexStrToStr将改名为hexToStr
        String raw2 = Convert.hexToStr(hex, CharsetUtil.CHARSET_UTF_8);
        System.out.println("raw2 = " + raw2);

        byte[] bytes = Convert.hexToBytes(hex);
        System.out.println("bytes = " + bytes);
    }

    /**
     * unicode和字符串转换
     */
    public static void unicodeAndStringConvert() {
        String a = "我是一个小小的可爱的字符串";

        //结果为："\\u6211\\u662f\\u4e00\\u4e2a\\u5c0f\\u5c0f\\u7684\\u53ef\\u7231\\u7684\\u5b57\\u7b26\\u4e32"
        String unicode = Convert.strToUnicode(a);
        System.out.println("unicode = " + unicode);

        //结果为："我是一个小小的可爱的字符串"
        String raw = Convert.unicodeToStr(unicode);
        System.out.println("raw = " + raw);
    }

    /**
     * 编码转换
     */
    public static void codingConvert() {
        String a = "我不是乱码";
        //转换后result为乱码
        String result = Convert.convertCharset(a, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
        String raw = Convert.convertCharset(result, CharsetUtil.ISO_8859_1, "UTF-8");
        // Assert.assertEquals(raw, a);

        System.out.println("raw.equals(a) = " + raw.equals(a));
    }

    /**
     * 时间单位转换
     */
    public static void timeUnitConvert() {
        long a = 4535345;

        //结果为：75
        long minutes = Convert.convertTime(a, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);

        System.out.println("minutes = " + minutes);
    }

    /**
     * 金额大小写转换
     */
    public static void amountCaseConvert() {
        double a = 67556.32;

        //结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
        String digitUppercase = Convert.digitToChinese(a);

        System.out.println("digitUppercase = " + digitUppercase);
    }

    /**
     * 数字转为英文表达
     */
    public static void digitalConvertEnglishExpress() {
        // ONE HUNDRED AND CENTS TWENTY THREE ONLY
        String format = Convert.numberToWord(100.23);

        System.out.println("format = " + format);
    }

    /**
     * 数字简化
     */
    public static void digitalSimplify() {
        // 1.2k
        String format = Convert.numberToSimple(1200);

        System.out.println("format = " + format);
    }

    /**
     * 数字转中文
     */
    public static void digitalConvertChinese() {
        // 一万零八百八十九点七二
        String f1 = Convert.numberToChinese(10889.72356, Boolean.FALSE);
        System.out.println("f1 = " + f1);

        // 使用金额大写
        // 壹万贰仟陆佰伍拾叁
        String f2 = Convert.numberToChinese(12653, Boolean.TRUE);
        System.out.println("f2 = " + f2);
    }

    /**
     * 数字中文转换为数字
     */
    public static void chineseNumberToNumber() {
        // 1012
        int f1 = Convert.chineseToNumber("一千零一十二");
        System.out.println("f1 = " + f1);
    }

    /**
     * 原始类和包装类转换
     */
    public static void originalClassPackagingConvert() {
        //去包装
        Class<?> wrapClass = Integer.class;

        //结果为：int.class
        Class<?> unWraped = Convert.unWrap(wrapClass);
        System.out.println("unWraped = " + unWraped);

        //包装
        Class<?> primitiveClass = long.class;
        //结果为：Long.class
        Class<?> wraped = Convert.wrap(primitiveClass);
        System.out.println("wraped = " + wraped);
    }

    /**
     * 自定义类型转换 ConverterRegistry
     */
    public static void customTypeConvert() {
        int a = 3423;
        ConverterRegistry converterRegistry = ConverterRegistry.getInstance();
        String result = converterRegistry.convert(String.class, a);
        // Assert.assertEquals("3423", result);

        System.out.println("\"3423\".equals(result) = " + "3423".equals(result));
    }

    // ========================================= 自定义转换 =========================================
    /**
     * 2.注册转换器
     */
    public static ConverterRegistry registeredConverter() {
        ConverterRegistry converterRegistry = ConverterRegistry.getInstance();

        // 此处做为示例自定义String转换，因为Hutool中已经提供String转换，请尽量不要替换
        // 替换可能引发关联转换异常（例如覆盖String转换会影响全局）
        converterRegistry.putCustom(String.class, CustomConverter.class);

        return converterRegistry;
    }

    /**
     * 3.执行转换
     */
    public static void execConvert() {
        int a = 454553;

        ConverterRegistry converterRegistry = registeredConverter();

        String result = converterRegistry.convert(String.class, a);
        // Assert.assertEquals("Custom: 454553", result);

        System.out.println("\"Custom: 454553\".equals(result) = " + "Custom: 454553".equals(result));
    }

    /**
     * 1.自定义转换器
     *
     * @author BNTang
     * @date 2023/01/11
     */
    public static class CustomConverter implements Converter<String> {
        @Override
        public String convert(Object value, String defaultValue) throws IllegalArgumentException {
            return "Custom: " + value.toString();
        }
    }
    // ========================================= 自定义转换 =========================================

    public static void main(String[] args) {
        // paramToString();
        // paramToArray();
        // paramToDate();
        // paramToList();
        // HalfAngleToFullAngle();
        // genericityConvert();
        // fullAngleToHalfAngle();
        // convertToSixTeenBase();
        // convertSixTeenBaseToString();
        // unicodeAndStringConvert();
        // codingConvert();
        // timeUnitConvert();
        // amountCaseConvert();
        // digitalConvertEnglishExpress();
        // digitalSimplify();
        // digitalConvertChinese();
        // chineseNumberToNumber();
        // originalClassPackagingConvert();
        // customTypeConvert();
        execConvert();
    }
}