package top.it6666.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.it6666.entity.User;
import top.it6666.mapper.UserMapper;
import top.it6666.service.IUserService;
import top.it6666.template.SaveUpdateDBTemplate;
import top.it6666.utils.DBResultUtil;

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
        return DBResultUtil.doBoolToInt(updateBatchById(elements));
    }

    @Override
    public int batchInsert(List<User> elements) {
        return DBResultUtil.doBoolToInt(saveBatch(elements));
    }
}