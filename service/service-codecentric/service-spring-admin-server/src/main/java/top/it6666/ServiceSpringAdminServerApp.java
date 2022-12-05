package top.it6666;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class ServiceSpringAdminServerApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSpringAdminServerApp.class, args);
    }
}