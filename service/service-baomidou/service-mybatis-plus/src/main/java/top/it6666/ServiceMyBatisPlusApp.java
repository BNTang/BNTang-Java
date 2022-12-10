package top.it6666;

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
@MapperScan("top.it6666.mapper")
public class ServiceMyBatisPlusApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceMyBatisPlusApp.class, args);
    }
}