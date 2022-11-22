package top.it6666.pojo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
        System.out.println("1. BNTangBean no parameter constructor start！");
    }

    @PostConstruct
    public void init() {
        System.out.println("2. call init method attribute config init method！");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("3. call destroy method attribute config init method！");
    }
}