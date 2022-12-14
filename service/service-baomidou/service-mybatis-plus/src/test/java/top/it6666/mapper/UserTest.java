package top.it6666.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import org.junit.jupiter.api.Test;
import top.it6666.entity.User;

import javax.annotation.Resource;
import java.util.List;

@MybatisPlusTest
class UserTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void testUserEnumInsertDb() {
        List<User> users = this.userMapper.selectList(null);
        System.out.println(users);
    }
}