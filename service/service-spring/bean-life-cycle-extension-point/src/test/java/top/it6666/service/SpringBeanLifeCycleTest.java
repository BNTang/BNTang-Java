package top.it6666.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.it6666.BeanLifeCycleApp;
import top.it6666.pojo.BNTangBean;

import javax.annotation.Resource;

/**
 * @author BNTang
 * @version V1.0
 * @project BNTang-Java
 * @date Created in 2022/11/22 23:07
 * @description
 **/
@SpringBootTest(classes = BeanLifeCycleApp.class)
public class SpringBeanLifeCycleTest {
    @Resource
    private BNTangBean bnTangBean;

    @Test
    public void testBeanLifeCycle(){
        System.out.println(bnTangBean);
    }
}