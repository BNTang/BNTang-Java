package top.it6666.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author BNTang
 * @version V1.0
 * @project BNTang-Java
 * @date Created in 2022/11/22 23:49
 * @description
 **/
@Component
public class BNTangBeanPostProcessor implements BeanPostProcessor {
    public BNTangBeanPostProcessor() {
        System.out.println("3. call BNTangBeanPostProcessor constructor");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("BNTangBean")) {
            System.out.println("12. call BeanPostProcessor of BeforeInitialization!");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("BNTangBean")) {
            System.out.println("15. call BeanPostProcessor of AfterInitialization!");
        }
        return bean;
    }
}