package top.it6666.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author BNTang
 * @version 1.0
 * @since 2022-15-20
 **/
@Configuration
@MapperScan("top.it6666.mapper")
public class MybatisPlusConfig {
}