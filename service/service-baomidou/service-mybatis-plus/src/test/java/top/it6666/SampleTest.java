package top.it6666;

import cn.hutool.core.lang.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.it6666.mapper.UserMapper;
import top.it6666.pojo.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author BNTang
 * @version V1.0
 * @project BNTang-Java
 * @date Created in 2022/12/1 23:41
 * @description
 **/
@SpringBootTest(classes = ServiceMyBatisPlusApp.class)
class SampleTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void testSelect() {
        List<User> userList = this.userMapper.selectList(null);
        Assert.equals(5, userList.size());
        userList.forEach(System.out::println);
    }
}
