package top.it6666.core.clone;

import lombok.Getter;
import lombok.Setter;

/**
 * @author BNTang
 * @version 1.0
 * @description JDK 自带克隆接口，浅克隆！！！
 * @since 2023-15-07
 **/
@Getter
@Setter
public class CatByJdkInterface implements Cloneable {
    /**
     * 名字
     */
    private String name = "miaomiao";
    /**
     * 年龄
     */
    private int age = 2;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}