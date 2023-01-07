- 官方文档地址：https://hutool.cn/

# core

## 支持泛型的克隆接口和克隆类

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

```

当然，使用CloneSupport的前提是你没有继承任何的类，谁让Java不支持多重继承呢（你依旧可以让父类继承这个类，如果可以的话）。如果没办法继承类，那实现cn.hutool.clone.Cloneable**也是不错的主意，因此hutool**提供了这两种方式，任选其一，在便捷和灵活上都提供了支持。