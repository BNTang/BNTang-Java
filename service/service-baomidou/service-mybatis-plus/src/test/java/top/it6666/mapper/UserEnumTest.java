package top.it6666.mapper;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import org.junit.jupiter.api.Test;
import top.it6666.entity.UserEnum;
import top.it6666.enums.AgeEnum;
import top.it6666.enums.GradeEnum;

import javax.annotation.Resource;

@MybatisPlusTest
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

        this.userEnumMapper.insert(userEnum);
    }
}