- 官方文档地址：https://hutool.cn/

# core

## 支持泛型的克隆接口和克隆类

> 空接口

- JDK中的Cloneable接口只是一个空接口，并没有定义成员；

![image-20230107141306389](https://img2023.cnblogs.com/blog/2105804/202301/2105804-20230107141309158-1409319880.png)

它存在的意义仅仅是指明一个类的实例化对象支持位复制（就是对象克隆），如果不实现这个类，调用对象的clone()方法就会抛出CloneNotSupportedException异常。而且，因为clone()方法在Object对象中，返回值也是Object对象，因此克隆后我们需要自己强转下类型。

## 泛型克隆接口

因此，**cn.hutool.core.clone.Cloneable** 接口应运而生。此接口定义了一个返回泛型的成员方法，这样，实现此接口后会提示必须实现一个public的clone方法，调用父类clone方法即可：