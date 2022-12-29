package top.it6666.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
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
        // 从命令行中获取密钥
        String mpwKey = environment.getPropertySources()
                .stream()
                .filter(SimpleCommandLinePropertySource.class::isInstance)
                .map(SimpleCommandLinePropertySource.class::cast)
                .map(source -> source.getProperty("mpw.key"))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);

        if (StringUtils.isEmpty(mpwKey)) {
            // 如果命令行中没有获取到密钥，就使用属性文件中的值
            Properties pro = new Properties();
            try (InputStream inputStream = new ClassPathResource("ert.properties").getInputStream()) {
                pro.load(inputStream);
            } catch (IOException e) {
                log.error("Error loading properties file", e);
            }
            environment.getPropertySources()
                    .addFirst(new SimpleCommandLinePropertySource("mySpringApplicationCommandLineArgs",
                            "--mpw.key=" + pro.getProperty("ert.version")));
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}