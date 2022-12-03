package top.it6666.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.it6666.entity.User;
import top.it6666.mapper.UserMapper;
import top.it6666.service.IUserService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author BNTang
 * @since 2022-12-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}