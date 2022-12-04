package top.it6666.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.it6666.entity.User;
import top.it6666.mapper.UserMapper;
import top.it6666.service.IUserService;
import top.it6666.template.SaveUpdateDBTemplate;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author BNTang
 * @since 2022-12-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements IUserService, SaveUpdateDBTemplate<User> {
    @Override
    public void saveUpdate(User user) {
        saveUpdate(CollUtil.newArrayList(user));
    }

    @Override
    public int batchUpdate(List<User> elements) {
        boolean result = updateBatchById(elements);
        System.out.println(result);
        return 0;
    }

    @Override
    public int batchInsert(List<User> elements) {
        boolean result = saveBatch(elements);
        System.out.println(result);
        return 0;
    }
}