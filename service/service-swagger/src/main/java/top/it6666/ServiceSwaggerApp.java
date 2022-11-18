package top.it6666;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableSwagger2Doc
//@EnableKnife4j
public class ServiceSwaggerApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSwaggerApp.class, args);
    }
}