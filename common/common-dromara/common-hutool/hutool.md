- 官方文档地址：https://hutool.cn/

# 克隆

- 支持泛型的克隆接口和克隆类

> 空接口

- JDK中的Cloneable接口只是一个空接口，并没有定义成员；

![image-20230107141306389](https://img2023.cnblogs.com/blog/2105804/202301/2105804-20230107141309158-1409319880.png)

它存在的意义仅仅是指明一个类的实例化对象支持位复制（就是对象克隆），如果不实现这个类，调用对象的clone()方法就会抛出CloneNotSupportedException异常。而且，因为clone()方法在Object对象中，返回值也是Object对象，因此克隆后我们需要自己强转下类型。

## 泛型克隆接口

因此，**cn.hutool.core.clone.Cloneable** 接口应运而生。此接口定义了一个返回泛型的成员方法，这样，实现此接口后会提示必须实现一个public的clone方法，调用父类clone方法即可：

```java
@Data
public class CatByHuTool implements Cloneable<CatByHuTool> {
    /**
     * 名字
     */
    private String name = "miaomiao";
    /**
     * 年龄
     */
    private int age = 2;

    @Override
    public CatByHuTool clone() {
        try {
            return (CatByHuTool) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneRuntimeException(e);
        }
    }
}
```

## 泛型克隆类

但是实现此接口依旧有不方便之处，就是必须自己实现一个public类型的clone()方法，还要调用父类（Object）的clone方法并处理异常。于是 **cn.hutool.clone.CloneSupport** 类产生，这个类帮我们实现了上面的clone方法，因此只要继承此类，不用写任何代码即可使用clone()方法：

```java
/**
 * @author BNTang
 * @version 1.0
 * @description
 * @since 2023-16-07
 **/
@Getter
@Setter
@ToString
public class DogByInherit extends CloneSupport<DogByInherit> {
    /**
     * 名字
     */
    private String name = "wangwang";
    /**
     * 年龄
     */
    private int age = 3;
}
```

当然，使用CloneSupport的前提是你没有继承任何的类，谁让Java不支持多重继承呢（你依旧可以让父类继承这个类，如果可以的话）。如果没办法继承类，那实现 **cn.hutool.clone.Cloneable** 也是不错的主意，因此hutool提供了这两种方式，任选其一，在便捷和灵活上都提供了支持。

## 深克隆

我们知道实现Cloneable接口后克隆的对象是浅克隆，要想实现深克隆，请使用：

```java
ObjectUtil.cloneByStream(obj)
```

前提是对象必须实现 `Serializable` 接口。

ObjectUtil同样提供一些静态方法：**clone(obj)、cloneIfPossible(obj)** 用于简化克隆调用。

# 类型转换

- 痛点

在Java开发中我们要面对各种各样的类型转换问题，尤其是从命令行获取的用户参数、从HttpRequest获取的Parameter等等，这些参数类型多种多样，我们怎么去转换他们呢？常用的办法是先整成String，然后调用XXX.parseXXX方法，还要承受转换失败的风险，不得不加一层try catch，这个小小的过程混迹在业务代码中会显得非常难看和臃肿。

## Convert 类

**Convert** 类可以说是一个工具方法类，里面封装了针对Java常见类型的转换，用于简化类型转换。**Convert** 类中大部分方法为 toXXX，参数为Object，可以实现将任意可能的类型转换为指定类型。同时支持第二个参数 **defaultValue** 用于在转换失败时返回一个默认值。

## Java 常见类型转换

- 转换为字符串：

```java
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
```

- 转换为指定类型数组：

```java
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
```

- 转换为日期对象：

```java
public static void paramToDate() {
    String a = "2017-05-06";
    Date value = Convert.toDate(a);
    System.out.println("value = " + value);
}
```

- 转换为集合：

```java
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
```

## 其它类型转换

### 标准类型

通过 `Convert.convert(Class<T>, Object)` 方法可以将任意类型转换为指定类型，Hutool 中预定义了许多类型转换，例如转换为 URI、URL、Calendar 等等, 这些类型的转换都依托于 `ConverterRegistry` 类。通过这个类和 `Converter` 接口，我们可以自定义一些类型转换，详细的使用请参阅 “自定义类型转换” 一节。

### 泛型类型

通过`convert(TypeReference<T> reference, Object value)`方法，自行new一个`TypeReference`对象可以对嵌套泛型进行类型转换。例如，我们想转换一个对象为`List<String>`类型，此时传入的标准Class就无法满足要求，此时我们可以这样：

```java
Object[] a = { "a", "你", "好", "", 1 };
List<String> list = Convert.convert(new TypeReference<List<String>>() {}, a);
```

通过 TypeReference 实例化后制定泛型类型，即可转换对象为我们想要的目标类型。

### 半角和全角转换

在很多文本的统一化中这两个方法非常有用，主要对标点符号的全角半角转换。[全角和半角的区别及使用方式](https://blog.csdn.net/someday1314/article/details/69934312)

- 半角转全角：

```java
public static void HalfAngleToFullAngle() {
    String a = "123456789";

    //结果为："１２３４５６７８９"
    String sbc = Convert.toSBC(a);
    System.out.println("sbc = " + sbc);
}
```

- 全角转半角：

```java
public static void fullAngleToHalfAngle() {
    String a = "１２３４５６７８９";

    //结果为"123456789"
    String dbc = Convert.toDBC(a);
    System.out.println("dbc = " + dbc);
}
```

### （Hex） 16 进制

在很多加密解密，以及中文字符串传输（比如表单提交）的时候，会用到 16 进制转换，就是 Hex 转换，为此Hutool中专门封装了 HexUtil 工具类，考虑到 16 进制转换也是转换的一部分，因此将其方法也放在 Convert 类中，便于理解和查找，使用同样非常简单：

- 转为16进制（Hex）字符串

```java
public static void convertToSixTeenBase() {
    String a = "我是一个小小的可爱的字符串";

    //结果："e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2"
    String hex = Convert.toHex(a, CharsetUtil.CHARSET_UTF_8);
    System.out.println("hex = " + hex);
}
```

- 将16进制（Hex）字符串转为普通字符串:

```java
public static void convertSixTeenBaseToString() {
    String hex = "e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2";

    //结果为："我是一个小小的可爱的字符串"
    //String raw = Convert.hexStrToStr(hex, CharsetUtil.CHARSET_UTF_8);

    //注意：在4.1.11之后hexStrToStr将改名为hexToStr
    String raw2 = Convert.hexToStr(hex, CharsetUtil.CHARSET_UTF_8);
    System.out.println("raw2 = " + raw2);
}
```

> 因为字符串牵涉到编码问题，因此必须传入编码对象，此处使用UTF-8编码。 **toHex** 方法同样支持传入 byte[]，同样也可以使用 **hexToBytes** 方法将16进制转为byte[]

### Unicode 和字符串转换

与16进制类似，Convert类同样可以在字符串和Unicode之间轻松转换：

```java
public static void unicodeAndStringConvert() {
    String a = "我是一个小小的可爱的字符串";

    //结果为："\\u6211\\u662f\\u4e00\\u4e2a\\u5c0f\\u5c0f\\u7684\\u53ef\\u7231\\u7684\\u5b57\\u7b26\\u4e32"
    String unicode = Convert.strToUnicode(a);
    System.out.println("unicode = " + unicode);

    //结果为："我是一个小小的可爱的字符串"
    String raw = Convert.unicodeToStr(unicode);
    System.out.println("raw = " + raw);
}
```

很熟悉吧？如果你在properties文件中写过中文，你会明白这个方法的重要性。

### 编码转换

在接收表单的时候，我们常常被中文乱码所困扰，其实大多数原因是使用了不正确的编码方式解码了数据。于是Convert.convertCharset方法便派上用场了，它可以把乱码转为正确的编码方式：

```java
public static void codingConvert() {
    String a = "我不是乱码";
    //转换后result为乱码
    String result = Convert.convertCharset(a, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
    String raw = Convert.convertCharset(result, CharsetUtil.ISO_8859_1, "UTF-8");
    // Assert.assertEquals(raw, a);

    System.out.println("raw.equals(a) = " + raw.equals(a));
}
```

!> 注意 经过测试，UTF-8编码后用GBK解码再用GBK编码后用UTF-8解码会存在某些中文转换失败的问题。

### 时间单位转换

`Convert.convertTime`方法主要用于转换时长单位，比如一个很大的毫秒，我想获得这个毫秒数对应多少分：

```java
public static void timeUnitConvert() {
    long a = 4535345;

    //结果为：75
    long minutes = Convert.convertTime(a, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);

    System.out.println("minutes = " + minutes);
}
```

### 金额大小写转换

面对财务类需求，Convert.digitToChinese将金钱数转换为大写形式：

```java
public static void amountCaseConvert() {
    double a = 67556.32;

    //结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
    String digitUppercase = Convert.digitToChinese(a);

    System.out.println("digitUppercase = " + digitUppercase);
}
```

!> 注意 转换为大写只能精确到`分`（小数点儿后两位），之后的数字会被忽略。

### 数字转换

- 数字转为英文表达

```java
public static void digitalConvertEnglishExpress() {
    // ONE HUNDRED AND CENTS TWENTY THREE ONLY
    String format = Convert.numberToWord(100.23);

    System.out.println("format = " + format);
}
```

- 数字简化

```java
public static void digitalSimplify() {
    // 1.2k
    String format = Convert.numberToSimple(1200);

    System.out.println("format = " + format);
}
```

- 数字转中文

!> 数字转中文方法中，只保留两位小数

```java
public static void digitalConvertChinese() {
    // 一万零八百八十九点七二
    String f1 = Convert.numberToChinese(10889.72356, false);
    System.out.println("f1 = " + f1);

    // 使用金额大写
    // 壹万贰仟陆佰伍拾叁
    String f2 = Convert.numberToChinese(12653, true);
    System.out.println("f2 = " + f2);
}
```

- 数字中文表示转换为数字

```java
public static void chineseNumberToNumber() {
    // 1012
    int f1 = Convert.chineseToNumber("一千零一十二");
    System.out.println("f1 = " + f1);
}
```

### 原始类和包装类转换

有的时候，我们需要将包装类和原始类相互转换（比如 Integer.class 和 int.class），这时候我们可以：

```java
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
```

## 自定义类型转换 ConverterRegistry

- 由来

Hutool中类型转换最早只是一个工具类，叫做“Convert”，对于每一种类型转换都是用一个静态方法表示，但是这种方式有一个潜在问题，那就是扩展性不足，这导致Hutool只能满足部分类型转换的需求。

- 解决

为了解决这些问题，我对Hutool中这个类做了扩展。思想如下：

- Converter 类型转换接口，通过实现这个接口，重写convert方法，以实现不同类型的对象转换;
- ConverterRegistry 类型转换登记中心。将各种类型Convert对象放入登记中心，通过convert方法查找目标类型对应的转换器，将被转换对象转换。在此类中，存放着默认转换器和自定义转换器，默认转换器是Hutool中预定义的一些转换器，自定义转换器存放用户自定的转换器;

通过这种方式，实现类灵活的类型转换。使用方式如下：

```java
public static void customTypeConvert() {
    int a = 3423;
    ConverterRegistry converterRegistry = ConverterRegistry.getInstance();
    String result = converterRegistry.convert(String.class, a);
    // Assert.assertEquals("3423", result);

    System.out.println("\"3423\".equals(result) = " + "3423".equals(result));
}
```

## 自定义转换

Hutool的默认转换有时候并不能满足我们自定义对象的一些需求，这时我们可以使用`ConverterRegistry.getInstance().putCustom()`方法自定义类型转换。

- 自定义转换器

```java
public static class CustomConverter implements Converter<String> {
    @Override
    public String convert(Object value, String defaultValue) throws IllegalArgumentException {
        return "Custom: " + value.toString();
    }
}
```

- 注册转换器

```java
public static ConverterRegistry registeredConverter() {
    ConverterRegistry converterRegistry = ConverterRegistry.getInstance();

    // 此处做为示例自定义String转换，因为Hutool中已经提供String转换，请尽量不要替换
    // 替换可能引发关联转换异常（例如覆盖String转换会影响全局）
    converterRegistry.putCustom(String.class, CustomConverter.class);

    return converterRegistry;
}
```

- 执行转换

```java
public static void execConvert() {
    int a = 454553;

    ConverterRegistry converterRegistry = registeredConverter();

    String result = converterRegistry.convert(String.class, a);
    // Assert.assertEquals("Custom: 454553", result);

    System.out.println("\"Custom: 454553\".equals(result) = " + "Custom: 454553".equals(result));
}
```

!> 注意：convert(Class type, Object value, T defaultValue, boolean isCustomFirst)方法的最后一个参数可以选择转换时优先使用自定义转换器还是默认转换器。convert(Class type, Object value, T defaultValue)和convert(Class type, Object value)两个重载方法都是使用自定义转换器优先的模式。

### ConverterRegistry 单例和对象模式

ConverterRegistry提供一个静态方法getInstance()返回全局单例对象，这也是推荐的使用方式，当然如果想在某个限定范围内自定义转换，可以实例化ConverterRegistry对象。

# 日期时间

> 介绍

日期时间包是Hutool的核心包之一，提供针对JDK中Date和Calendar对象的封装，封装对象如下：

>  日期时间工具

- `DateUtil` 针对日期时间操作提供一系列静态方法
- `DateTime` 提供类似于Joda-Time中日期时间对象的封装，继承自Date类，并提供更加丰富的对象方法。
- `FastDateFormat` 提供线程安全的针对Date对象的格式化和日期字符串解析支持。此对象在实际使用中并不需要感知，相关操作已经封装在`DateUtil`和`DateTime`的相关方法中。
- `DateBetween` 计算两个时间间隔的类，除了通过构造新对象使用外，相关操作也已封装在`DateUtil`和`DateTime`的相关方法中。
- `TimeInterval` 一个简单的计时器类，常用于计算某段代码的执行时间，提供包括毫秒、秒、分、时、天、周等各种单位的花费时长计算，对象的静态构造已封装在`DateUtil`中。
- `DatePattern` 提供常用的日期格式化模式，包括`String`类型和`FastDateFormat`两种类型。

> 日期枚举

考虑到`Calendar`类中表示时间的字段（field）都是使用`int`表示，在使用中非常不便，因此针对这些`int`字段，封装了与之对应的Enum枚举类，这些枚举类在`DateUtil`和`DateTime`相关方法中做为参数使用，可以更大限度的缩小参数限定范围。

这些定义的枚举值可以通过`getValue()`方法获得其与`Calendar`类对应的int值，通过`of(int)`方法从`Calendar`中int值转为枚举对象。

与`Calendar`对应的这些枚举包括：

- `Month` 表示月份，与Calendar中的int值一一对应。
- `Week` 表示周，与Calendar中的int值一一对应

> 月份枚举

通过月份枚举可以获得某个月的最后一天

```java
public static void dateTimeMonthEnum() {
    // 31
    int lastDay = Month.of(Calendar.JANUARY).getLastDay(false);
    System.out.println("lastDay = " + lastDay);
}
```

另外，Hutool还定义了季度枚举。Season.SPRING为第一季度，表示1~3月。季度的概念并不等同于季节，因为季节与月份并不对应，季度常用于统计概念。

> 时间枚举

时间枚举`DateUnit`主要表示某个时间单位对应的毫秒数，常用于计算时间差。

例如：`DateUnit.MINUTE`表示分，也表示一分钟的毫米数，可以通过调用其`getMillis()`方法获得其毫秒数。

## DateUtil

> 由来

考虑到Java本身对日期时间的支持有限，并且Date和Calendar对象的并存导致各种方法使用混乱和复杂，故使用此工具类做了封装。这其中的封装主要是日期和字符串之间的转换，以及提供对日期的定位（一个月前等等）。

对于Date对象，为了便捷，使用了一个DateTime类来代替，继承自Date对象，主要的便利在于，覆盖了toString()方法，返回yyyy-MM-dd HH:mm:ss形式的字符串，方便在输出时的调用（例如日志记录等），提供了众多便捷的方法对日期对象操作，关于DateTime会在相关章节介绍。

> 方法

- 转换

Date、long、Calendar之间的相互转换: 

```java
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
```

- 字符串转日期

`DateUtil.parse`方法会自动识别一些常用格式，包括：

- yyyy-MM-dd HH:mm:ss
- yyyy/MM/dd HH:mm:ss
- yyyy.MM.dd HH:mm:ss
- yyyy年MM月dd日 HH时mm分ss秒
- yyyy-MM-dd
- yyyy/MM/dd
- yyyy.MM.dd
- HH:mm:ss
- HH时mm分ss秒
- yyyy-MM-dd HH:mm
- yyyy-MM-dd HH:mm:ss.SSS
- yyyyMMddHHmmss
- yyyyMMddHHmmssSSS
- yyyyMMdd
- EEE, dd MMM yyyy HH:mm:ss z
- EEE MMM dd HH:mm:ss zzz yyyy
- yyyy-MM-dd'T'HH:mm:ss'Z'
- yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
- yyyy-MM-dd'T'HH:mm:ssZ
- yyyy-MM-dd'T'HH:mm:ss.SSSZ

```java
public static void stringConvertDate() {
    String dateStr = "2017-03-01";
    Date date = DateUtil.parse(dateStr);
    System.out.println("date = " + date);
}
```

我们也可以使用自定义日期格式转化：

```JAVA
public static void customDateFormatStringToDate() {
    String dateStr = "2017-03-01";
    Date date = DateUtil.parse(dateStr, "yyyy-MM-dd");
    System.out.println("date = " + date);
}
```

- 格式化日期输出

```java
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
```

- 获取Date对象的某个部分

```java
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
```

- 开始和结束时间

有的时候我们需要获得每天的开始时间、结束时间，每月的开始和结束时间等等，DateUtil也提供了相关方法：

```java
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
```

- 日期时间偏移

日期或时间的偏移指针对某个日期增加或减少分、小时、天等等，达到日期变更的目的。Hutool也针对其做了大量封装: 

```java
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
```

- 针对当前时间，提供了简化的偏移方法（例如昨天、上周、上个月等）：

```java
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
```

- 日期时间差

有时候我们需要计算两个日期之间的时间差（相差天数、相差小时数等等），Hutool将此类方法封装为between方法：

```java
public static void dateTimeDifference(){
    String dateStr1 = "2017-03-01 22:33:23";
    Date date1 = DateUtil.parse(dateStr1);

    String dateStr2 = "2017-04-01 23:33:23";
    Date date2 = DateUtil.parse(dateStr2);

    // 相差一个月，31天
    long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);
    System.out.println("betweenDay = " + betweenDay);
}
```

- 格式化时间差

有时候我们希望看到易读的时间差，比如XX天XX小时XX分XX秒，此时使用`DateUtil.formatBetween`方法：

```java
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
```

- 星座和属相

```java
public static void constellationAndChineseZodiac() {
    // "双子座"
    String zodiac = DateUtil.getZodiac(Month.MAY.getValue(), 25);
    System.out.println("zodiac = " + zodiac);

    // "狗"
    String chineseZodiac = DateUtil.getChineseZodiac(2001);
    System.out.println("chineseZodiac = " + chineseZodiac);
}
```

- 其它