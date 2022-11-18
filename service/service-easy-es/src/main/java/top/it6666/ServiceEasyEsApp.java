package top.it6666;

import cn.easyes.starter.register.EsMapperScan;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@EnableKnife4j
@SpringBootApplication
@EsMapperScan("top.it6666.mapper")
public class ServiceEasyEsApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceEasyEsApp.class, args);
    }
}