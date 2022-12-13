package top.it6666.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import top.it6666.properties.BNTangSwagger2Properties;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * @author BNTang
 * @version 1.0
 * @since 2022-20-10
 **/
@Configuration
// 表示开启Swagger功能
@EnableSwagger2
public class BNTangSwagger2Config {
    @Resource
    private BNTangSwagger2Properties bnTangSwagger2Properties;

    @Bean
    public Docket swaggerApi() {
        return
                new Docket(DocumentationType.SWAGGER_2)
                        .select()

                        // 表示将 top.it6666.controller 路径下的所有 Controller 都添加进去
                        .apis(RequestHandlerSelectors.basePackage(bnTangSwagger2Properties.getBasePackage()))

                        // 表示Controller里的所有方法都纳入
                        .paths(PathSelectors.any())
                        .build()

                        // 用于定义一些API页面信息，比如作者名称，邮箱，网站链接，开源协议等等
                        .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                bnTangSwagger2Properties.getTitle(),
                bnTangSwagger2Properties.getDescription(),
                bnTangSwagger2Properties.getVersion(),
                null,
                new Contact(bnTangSwagger2Properties.getAuthor(), bnTangSwagger2Properties.getUrl(), bnTangSwagger2Properties.getEmail()),
                bnTangSwagger2Properties.getLicense(), bnTangSwagger2Properties.getLicenseUrl(), Collections.emptyList());
    }
}