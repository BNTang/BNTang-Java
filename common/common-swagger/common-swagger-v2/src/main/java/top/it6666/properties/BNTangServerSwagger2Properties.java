package top.it6666.properties;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @author BNTang
 * @version 1.0
 * @since 2022-10-11
 **/
@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:bntang-swagger2.properties"})
@ConfigurationProperties(prefix = "bntang.swagger2")
public class BNTangServerSwagger2Properties {
    private BNTangSwagger2Properties bnTangSwagger2Properties = new BNTangSwagger2Properties();
}