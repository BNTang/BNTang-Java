package top.it6666.config;

import cn.hutool.core.text.CharSequenceUtil;
import org.springframework.beans.factory.InitializingBean;
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
import top.it6666.properties.BNTangServerSwagger2Properties;
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
public class BNTangSwagger2Config implements InitializingBean {
    @Value("${swagger2.title}")
    private String title;
    @Value("${swagger2.description}")
    private String description;

    @Resource
    private BNTangServerSwagger2Properties bnTangSwagger2Properties;

    @Bean
    public Docket swaggerApi() {
        BNTangSwagger2Properties swagger2 = bnTangSwagger2Properties.getBnTangSwagger2Properties();
        return new Docket(DocumentationType.SWAGGER_2)
                .select()

                // 表示将 top.it6666.controller 路径下的所有 Controller 都添加进去
                .apis(RequestHandlerSelectors.basePackage(swagger2.getBasePackage()))

                // 表示Controller里的所有方法都纳入
                .paths(PathSelectors.any())
                .build()

                // 用于定义一些API页面信息，比如作者名称，邮箱，网站链接，开源协议等等
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        BNTangSwagger2Properties swagger2 = bnTangSwagger2Properties.getBnTangSwagger2Properties();
        return new ApiInfo(
                swagger2.getTitle(),
                swagger2.getDescription(),
                swagger2.getVersion(),
                null,
                new Contact(swagger2.getAuthor(), swagger2.getUrl(), swagger2.getEmail()),
                swagger2.getLicense(), swagger2.getLicenseUrl(), Collections.emptyList());
    }

    @Override
    public void afterPropertiesSet() {
        BNTangSwagger2Properties swagger2 = bnTangSwagger2Properties.getBnTangSwagger2Properties();
        if (CharSequenceUtil.isNotBlank(title)) {
            swagger2.setTitle(title);
        }
        if (CharSequenceUtil.isNotBlank(description)) {
            swagger2.setDescription(description);
        }
    }
}