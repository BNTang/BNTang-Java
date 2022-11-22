package top.it6666.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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
public class BNTangBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware,
        ApplicationContextAware {
    /**
     * 名字
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * bean名字
     */
    private String beanName;

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

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
        System.out.println("6. call BeanNameAware setBeanName " + beanName);
    }

    @Override
    public String toString() {
        return "BNTangBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("7. call BeanFactoryAware interface setBeanFactory");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBeanName() {
        return beanName;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("8. call ApplicationContextAware interface of setApplicationContext");
    }
}