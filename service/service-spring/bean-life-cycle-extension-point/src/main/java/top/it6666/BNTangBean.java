package top.it6666;

import org.springframework.stereotype.Component;

/**
 * @author BNTang
 * @version V1.0
 * @project BNTang-Java
 * @date Created in 2022/11/22 22:58
 * @description Bean 生命周期与扩展点
 **/
@Component
public class BNTangBean {
    /**
     * 名字
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    public BNTangBean() {
        System.out.println("BNTangBean 无参构造器 start！");
    }
}