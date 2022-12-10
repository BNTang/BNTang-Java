package top.it6666;

import cn.easyes.starter.register.EsMapperScan;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableKnife4j
@SpringBootApplication
@EsMapperScan("top.it6666.mapper")
public class ServiceEasyEsApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceEasyEsApp.class, args);
    }
}