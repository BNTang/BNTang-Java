package top.it6666.config;

import cn.hutool.core.text.CharSequenceUtil;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.it6666.properties.BNTangServerSwagger3Properties;
import top.it6666.properties.BNTangSwagger3Properties;

import javax.annotation.Resource;

@Configuration
public class OpenApiConfig implements InitializingBean {
    @Value("${swagger3.title}")
    private String title;
    @Value("${swagger3.description}")
    private String description;
    @Value("${swagger3.version}")
    private String version;
    @Resource
    private BNTangServerSwagger3Properties bnTangServerSwagger3Properties;

    @Bean
    public OpenAPI api() {
        BNTangSwagger3Properties swagger3 = bnTangServerSwagger3Properties.getBnTangSwagger3Properties();
        Info info = new Info()
                .title(swagger3.getTitle())
                .description(swagger3.getDescription())
                .version(swagger3.getVersion());
        return new OpenAPI().info(info);
    }
    @Bean
    public GroupedOpenApi publicApi() {
        BNTangSwagger3Properties swagger3 = bnTangServerSwagger3Properties.getBnTangSwagger3Properties();
        return GroupedOpenApi.builder()
                .group(swagger3.getGroup())
                .pathsToMatch(swagger3.getPaths())
                .build();
    }

    @Override
    public void afterPropertiesSet() {
        BNTangSwagger3Properties swagger3 = bnTangServerSwagger3Properties.getBnTangSwagger3Properties();
        if (CharSequenceUtil.isNotBlank(title)) {
            swagger3.setTitle(title);
        }
        if (CharSequenceUtil.isNotBlank(description)) {
            swagger3.setDescription(description);
        }
        if (CharSequenceUtil.isNotBlank(version)) {
            swagger3.setVersion(version);
        }
    }
}