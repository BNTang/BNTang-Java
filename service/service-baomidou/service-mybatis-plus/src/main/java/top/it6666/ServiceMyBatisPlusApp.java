package top.it6666;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author BNTang
 * @version V1.0
 * @project BNTang-Java
 * @date Created in 2022/12/1 23:38
 * @description
 **/
@SpringBootApplication
//@EnableSwagger2Doc
//@EnableKnife4j
@MapperScan("top.it6666.mapper")
public class ServiceMyBatisPlusApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceMyBatisPlusApp.class, args);
    }
}