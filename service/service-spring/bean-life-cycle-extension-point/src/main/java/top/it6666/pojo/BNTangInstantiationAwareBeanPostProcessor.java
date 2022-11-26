package top.it6666.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * @author BNTang
 * @version V1.0
 * @project BNTang-Java
 * @date Created in 2022/11/26 12:45
 * @description spring 启动时，会创建所有的 BeanPostProcessor，这是spring自己默认的，我们的一般都是属于自定义的
 **/
@Component
public class BNTangInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    /**
     * 实例化之前 call
     */
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    /**
     * 实例化之后 call
     */
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    /**
     * 当属性处理完之后会传入进来
     */
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return null;
    }
}