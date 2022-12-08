package top.it6666;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2Doc
@EnableKnife4j
public class ServiceSwaggerV2App {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSwaggerV2App.class, args);
    }
}