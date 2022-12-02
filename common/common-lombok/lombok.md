# val

> 自动类型推断

```java
val s = "BNTang";

---

String s = "BNTang";
```

var 与 val 功能相似，是鉴于 JEP 286 建立的，在 jdk10 官方已加入该关键字，可以在 jdk10 之前版本用 lombok 的 var 提前体验。

# @NonNull

不能为空，如果传入了空，则抛 NPE 异常，如果给的不为 null 则使用传入的变量参数内容, 意思就是当你在方法的参数上标注了该注解，会在该方法前面多编译出一些 null 的判断，如果是 nul l则直接抛 NPE 异常, 貌似只有在方法参数上有作用。

```java
private void testNonFn(@NonNull String str){
    System.out.println(str);
}

↓ 编译之后的

private void testNonFn(@NonNull String str) {
    if (str == null) {
        throw new NullPointerException("str is marked non-null but is null");
    } else {
        System.out.println(str);
    }
}
```

官方 Demo：https://projectlombok.org/features/NonNull

# @Cleanup

在 java 中继承了 Closeable 接口的类有很多，他们一般都是需要释放资源的，这很麻烦，都需要我们手动调用，虽然 java7 引入了 `try-with-resources`，但他只支持 Closeable 接口 或者 AutoCloseable 接口, 用 lombok 的 `@Cleanup` 则很容易做到释放资源, 先看下该注解的源代码：

```java
@Target({ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
public @interface Cleanup {
    String value() default "close";
}
```

可以看出，该注解只能使用在 `局部变量` 上，他的作用大致是，在变量前声明该注解，随后的代码会被包裹在 try 代码块里，会在 finally 代码块里调用该注解 的 value 值，默认是 close，也可以指定自己的方法，在调用前会判断非 null，他的判断非 null 很奇特，可以观赏一下：

示例代码：

```java
@Test
void testCleanUpExample() {
    @Cleanup("close1") a a = new a();
    System.out.println(a);
}

class a {
    public void close1() {
        System.out.println("调用了释放资源");
    }
}

---

top.it6666.LomBokTest$a@47dd778
调用了释放资源
```

可以看到我的代码中并没有调用 close1 方法，然仍然有打印，说明 lombok 帮我们编译出了一些新代码，来看看：

```java
@Test
void testCleanUpExample() {
    a a = new a();

    try {
        System.out.println(a);
    } finally {
        if (Collections.singletonList(a).get(0) != null) {
            a.close1();
        }
    }
}
```

他先将 a 放到了一个不可变 list 里，然后再 get 出来判断 null，暂时没明白为什么这么做, 明明可以直接 a != null。

# @RequiredArgsConstructor

- 会生成只带有类里的 final 属性和 @NonNull 注解修饰的有参构造器

示例代码：

```java
@Test
void testRequiredArgsConstructor(){
    b b = new b(28, 1);
    System.out.println(b);
}

@RequiredArgsConstructor
class b{
    private final Integer age;

    private Integer age2;

    @NonNull
    private Integer gender;
}
```

编译之后的源代码：

```java
@Test
void testRequiredArgsConstructor() {
    b b = new b(28, 1);
    System.out.println(b);
}

class b {
    private final Integer age;
    private Integer age2;
    private @NonNull Integer gender;

    public b(final @NonNull Integer age, final Integer gender) {
        if (gender == null) {
            throw new NullPointerException("gender is marked non-null but is null");
        } else {
            this.age = age;
            this.gender = gender;
        }
    }
}
```

# @SneakyThrows

这个注解用在 `方法` 上，可以将方法中的代码用 `try-catch` 语句包裹起来，捕获异常并在 catch 中用 `Lombok.sneakyThrow(e)` 把异常抛出，可以使用 `@SneakyThrows(Exception.class)` 的形式指定抛出哪种异常，很简单的注解，直接看个例子，栗子这里先不提供。

参考文章：https://www.jianshu.com/p/f1cc67513aee

# @Builder

> 使用 @Builder 的时候，最好和 @AllArgsConstructor，@NoArgsConstructor 一起用