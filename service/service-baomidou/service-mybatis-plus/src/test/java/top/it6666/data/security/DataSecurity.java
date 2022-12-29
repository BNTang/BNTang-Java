package top.it6666.data.security;

import com.baomidou.mybatisplus.core.toolkit.AES;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author BNTang
 * @version 1.0
 * @since 2022-14-29
 **/
@SpringBootTest
class DataSecurity {
    @Test
    void testPwd() {
        String secretKey = AES.generateRandomKey();
        System.out.println("secretKey:" + secretKey);

        String url = AES.encrypt("jdbc:p6spy:mysql://lzys522.cn:3310/mybatisplus?useUnicode=true&useSSL=false&characterEncoding=utf8", secretKey);
        String username = AES.encrypt("root", secretKey);
        String password = AES.encrypt("yangbuyiya", secretKey);
        System.out.println("url=" +url );
        System.out.println("username=" +username );
        System.out.println("password=" +password );
    }
}