package top.it6666.pojo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
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
public class BNTangBean implements InitializingBean, DisposableBean {
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
    public void myInit() {
        System.out.println("2. call myInit method attribute config init method！");
    }

    @PreDestroy
    public void myDestroy() {
        System.out.println("3. call myDestroy method attribute config init method！");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("4. call InitializingBean interface afterPropertiesSet");
    }

    @Override
    public void destroy() {
        System.out.println("5. call DisposableBean interface destroy");
    }
}