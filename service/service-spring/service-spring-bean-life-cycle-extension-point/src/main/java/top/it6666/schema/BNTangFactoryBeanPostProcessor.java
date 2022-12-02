package top.it6666.schema;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author BNTang
 * @version V1.0
 * @project BNTang-Java
 * @date Created in 2022/11/26 12:23
 * @description
 **/
@Component
public class BNTangFactoryBeanPostProcessor implements BeanFactoryPostProcessor {
    public BNTangFactoryBeanPostProcessor() {
        System.out.println("1. call BNTangFactoryBeanPostProcessor constructor");
    }

    /**
     * 调用时机：当 BeanFactory 创建完之后自动调用此方法
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("2. call BeanFactoryPostProcessor of postProcessBeanFactory");
    }
}