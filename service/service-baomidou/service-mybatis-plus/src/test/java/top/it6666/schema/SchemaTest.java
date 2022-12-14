package top.it6666.schema;

import cn.hutool.core.lang.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.it6666.ServiceMyBatisPlusApp;
import top.it6666.mapper.SchemaCustomerMapper;
import top.it6666.mapper.SchemaTUserMapper;

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
class SchemaTest {
    @Resource
    private SchemaTUserMapper schemaUserMapper;
    @Resource
    private SchemaCustomerMapper customerMapper;

    @Test
    void testCustomerSelect() {
        List<Customer> customerList = this.customerMapper.selectList(null);
        Assert.equals(7, customerList.size());
        customerList.forEach(System.out::println);
    }

    @Test
    void testUserSelect() {
        List<TUser> userList = this.schemaUserMapper.selectList(null);
        Assert.equals(5, userList.size());
        userList.forEach(System.out::println);
    }
}