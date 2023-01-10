package top.it6666.core.clone;

import cn.hutool.core.clone.CloneSupport;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author BNTang
 * @version 1.0
 * @description 泛型克隆类
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