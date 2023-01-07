package top.it6666.core.clone;

import lombok.Data;

/**
 * @author BNTang
 * @version 1.0
 * @description
 * @since 2023-15-07
 **/
@Data
public class CatByJdk implements Cloneable {
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