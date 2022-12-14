package top.it6666.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import top.it6666.entity.UserEnum;
import top.it6666.enums.AgeEnum;
import top.it6666.enums.GradeEnum;

import javax.annotation.Resource;

@MybatisPlusTest
// Failed to replace DataSource with an embedded database for tests. If you want an embedded database p
// 解决方案：https://blog.csdn.net/datou123789/article/details/108655648
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserEnumTest {
    @Resource
    private UserEnumMapper userEnumMapper;

    @Test
    void testUserEnumInsertDb() {
        UserEnum userEnum = new UserEnum();
//        userEnum.setId(new Double(Math.random()).longValue());
        userEnum.setId(Math.round(Math.random() * 100));
        userEnum.setName("name");
        userEnum.setAge(AgeEnum.ONE);
        userEnum.setGrade(GradeEnum.HIGH);
        userEnum.setEmail("303158131@qq.com");

        System.out.println(this.userEnumMapper.insert(userEnum));
    }
}