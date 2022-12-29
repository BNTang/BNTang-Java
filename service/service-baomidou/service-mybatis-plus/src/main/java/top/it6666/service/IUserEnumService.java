package top.it6666.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.it6666.entity.UserEnum;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author BNTang
 * @since 2022-12-03
 */
public interface IUserEnumService extends IService<UserEnum> {
    void testUserEnum(UserEnum userEnum);

    List<UserEnum> getUserEnumList();

    List<Map<String, Object>> testPaging(Integer page, Integer pageSize);

    List<UserEnum> testMapperPaging(Integer page, Integer pageSize);
}