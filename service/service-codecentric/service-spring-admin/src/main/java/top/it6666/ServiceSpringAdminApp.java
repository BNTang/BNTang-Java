package top.it6666;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class ServiceSpringAdminApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSpringAdminApp.class, args);
    }
}