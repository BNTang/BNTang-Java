package top.it6666;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author BNTang
 * @version V1.0
 * @project BNTang-Java
 * @date Created in 2022/12/1 23:38
 * @description
 **/
@EnableKnife4j
//@EnableSwagger2Doc
@EnableWebMvc
@MapperScan("top.it6666.mapper")
@SpringBootApplication
public class ServiceMyBatisPlusApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceMyBatisPlusApp.class, args);
    }
}