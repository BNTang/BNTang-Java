package top.it6666.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI api() {
        Info info = new Info()
                .title("文档标题")
                .description("文档描述")
                .version("v1.0.0");

        return new OpenAPI().info(info);
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("基础接口")
                .pathsToMatch("/**")
                .build();
    }
}