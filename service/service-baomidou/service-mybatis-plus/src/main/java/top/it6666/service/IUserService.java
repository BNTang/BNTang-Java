package top.it6666.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.it6666.entity.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author BNTang
 * @since 2022-12-03
 */
public interface IUserService extends IService<User> {
    void saveUpdate(User user);
}