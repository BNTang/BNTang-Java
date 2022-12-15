//package top.it6666.config;
//
//
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import springfox.documentation.builders.*;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.schema.ScalarType;
//import springfox.documentation.service.*;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.net.InetAddress;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * className SwaggerConfig
// * description SwaggerConfig
// *
// * @author BNTang
// * @version 1.0
// * @date 2022年12月14日18:36:22
// * @since 1.8
// */
//@Slf4j
//@Configuration
//@EnableOpenApi
//public class Swagger3Config {
//    @Value("${server.port}")
//    private int port;
//
//    // server.servlet.context-path: https://blog.csdn.net/qq_38322527/article/details/101691785
//    @Value("${server.servlet.context-path:}")
//    private String contextPath;
//
//    @Bean
//    @SneakyThrows
//    public Docket createApi() {
//        String ipAddress = this.getLocalIP();
//        // 控制台输出Knife4j增强接口文档地址
//        log.info("swagger3 接口文档地址: http://{}:{}{}/swagger-ui/index.html#/", ipAddress, port, contextPath);
//        log.info("Knife4j 增强接口文档地址: http://{}:{}{}/doc.html", ipAddress, port, contextPath);
//        log.info("Knife4j 增强接口文档地址《计算机名称》: http://{}:{}{}/doc.html", InetAddress.getLocalHost().getHostName(), port, contextPath);
//
//        return new Docket(DocumentationType.OAS_30)
//                .apiInfo(apiInfo())
//                .globalRequestParameters(getGlobalRequestParameters())
//                // 设置自定义返回消息体
//                .globalResponses(HttpMethod.GET, globalResponse())
//                .globalResponses(HttpMethod.POST, globalResponse())
//                .select()
//                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .apis(RequestHandlerSelectors.basePackage("top.it6666.controller"))
//                .paths(PathSelectors.any())
//                .build();
//        //.groupName("demo Pro");
//    }
//
//    /**
//     * 功能描述: API接口说明
//     **/
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("BNTang Swagger3 API")
//                .description("BNTang Swagger3 API")
//                .termsOfServiceUrl(null)
//                .contact(new Contact("BNTang",
//                        "https://www.cnblogs.com/BNTang",
//                        "303158131@qq.com"))
//                .version("1.0")
//                .build();
//    }
//
//    /**
//     * 功能描述: 生成全局通用参数
//     **/
//    private List<RequestParameter> getGlobalRequestParameters() {
//        List<RequestParameter> parameters = new ArrayList<>();
//        // 设置请求头
//        parameters.add(new RequestParameterBuilder()
//                .name("user_code")
//                .description("当前登录用户编码【开发自测时使用】")
//                .required(false)
//                .in(ParameterType.HEADER)
//                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
//                .required(false)
//                .build());
//        return parameters;
//    }
//
//    /**
//     * 功能描述: globalResponse
//     **/
//    private List<Response> globalResponse() {
//        List<Response> responseList = new ArrayList<>();
//        responseList.add(new ResponseBuilder().code("400").description("错误请求").build());
//        responseList.add(new ResponseBuilder().code("401").description("未认证").build());
//        responseList.add(new ResponseBuilder().code("403").description("请求被禁止").build());
//        responseList.add(new ResponseBuilder().code("404").description("找不到资源").build());
//        responseList.add(new ResponseBuilder().code("500").description("服务器内部错误").build());
//        return responseList;
//    }
//
//    @SneakyThrows
//    public String getLocalIP() {
//        return InetAddress.getLocalHost().getHostAddress();
//    }
//}