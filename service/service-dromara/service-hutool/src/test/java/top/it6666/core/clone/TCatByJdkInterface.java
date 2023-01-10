package top.it6666.core.clone;

import lombok.SneakyThrows;

/**
 * @author BNTang
 * @version 1.0
 * @description 测试 JDK 自带克隆接口，浅克隆！！！
 * @since 2023-15-07
 **/
public class TCatByJdkInterface {
    @SneakyThrows
    public static void main(String[] args) {
        CatByJdkInterface catByJdkInterface = new CatByJdkInterface();
        System.out.println("catByJdkInterface = " + catByJdkInterface);
        System.out.println(catByJdkInterface.hashCode());

        CatByJdkInterface clone = (CatByJdkInterface) catByJdkInterface.clone();
        clone.setName("BNTang");
        System.out.println("clone = " + clone);
        System.out.println(clone.hashCode());
    }
}