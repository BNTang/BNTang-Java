package top.it6666;

import cn.easyes.starter.register.EsMapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EsMapperScan("top.it6666.mapper")
public class ServiceEasyEsApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceEasyEsApp.class, args);
    }
}