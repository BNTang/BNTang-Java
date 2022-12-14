package top.it6666.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.it6666.entity.UserEnum;

import java.util.List;

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
}