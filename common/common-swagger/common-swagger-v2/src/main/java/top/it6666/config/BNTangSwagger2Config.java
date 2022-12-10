package top.it6666.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author BNTang
 * @version 1.0
 * @since 2022-20-10
 **/
@Configuration
@EnableSwagger2
public class BNTangSwagger2Config {
    @Value("${swagger2.title}")
    private String title;
    @Value("${swagger2.description}")
    private String description;

    @Bean
    public Docket swaggerApi() {
        return
                new Docket(DocumentationType.SWAGGER_2)
                        .select()
                        .apis(RequestHandlerSelectors.basePackage("top.it6666.controller"))
                        .paths(PathSelectors.any())
                        .build()
                        .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                title,
                description,
                "1.0",
                null,
                new Contact("BNTang", "https://www.cnblogs.com/BNTang", "303158131@qq.com"),
                "Apache 2.0", "https://www.apache.org/licenses/LICENSE-2.0.html", Collections.emptyList());
    }
}