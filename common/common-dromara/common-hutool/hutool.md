- 官方文档地址：https://hutool.cn/

# core

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

# Convert

- 痛点

在Java开发中我们要面对各种各样的类型转换问题，尤其是从命令行获取的用户参数、从HttpRequest获取的Parameter等等，这些参数类型多种多样，我们怎么去转换他们呢？常用的办法是先整成String，然后调用XXX.parseXXX方法，还要承受转换失败的风险，不得不加一层try catch，这个小小的过程混迹在业务代码中会显得非常难看和臃肿。

## Convert 类

**Convert** 类可以说是一个工具方法类，里面封装了针对Java常见类型的转换，用于简化类型转换。**Convert** 类中大部分方法为 toXXX，参数为Object，可以实现将任意可能的类型转换为指定类型。同时支持第二个参数 **defaultValue** 用于在转换失败时返回一个默认值。

## Java 常见类型转换

- 转换为字符串：