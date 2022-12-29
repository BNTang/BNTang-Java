package top.it6666.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author BNTang
 * @version 1.0
 * @description 安全加密处理器 https://zhuanlan.zhihu.com/p/584590516
 * @since 2022-14-29
 **/
@Slf4j
public class BNTangSafetyEncryptProcessor implements EnvironmentPostProcessor, Ordered {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Properties pro = new Properties();
        try (InputStream inputStream = new ClassPathResource("ert.properties").getInputStream()) {
            pro.load(inputStream);
        } catch (IOException e) {
            log.error("Error loading properties file", e);
        }

        // 命令行中获取密钥
        String mpwKey = null;
        for (PropertySource<?> ps : environment.getPropertySources()) {
            if (ps instanceof SimpleCommandLinePropertySource) {
                SimpleCommandLinePropertySource source = (SimpleCommandLinePropertySource) ps;
                mpwKey = source.getProperty("mpw.key");
                break;
            }
        }
        if (StringUtils.isEmpty(mpwKey)) {
            environment.getPropertySources()
                    .addFirst(new SimpleCommandLinePropertySource("mySpringApplicationCommandLineArgs", "--mpw.key="
                            + pro.getProperty("ert.version")));
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}