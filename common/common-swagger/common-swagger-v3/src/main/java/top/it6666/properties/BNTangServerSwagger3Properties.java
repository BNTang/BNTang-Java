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
@PropertySource(value = {"classpath:bntang-swagger3.properties"})
@ConfigurationProperties(prefix = "bntang.swagger3")
public class BNTangServerSwagger3Properties {
    private BNTangSwagger3Properties bnTangSwagger3Properties = new BNTangSwagger3Properties();
}