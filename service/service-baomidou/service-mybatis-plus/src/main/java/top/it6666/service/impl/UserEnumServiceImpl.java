package top.it6666.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.it6666.entity.UserEnum;
import top.it6666.mapper.UserEnumMapper;
import top.it6666.service.IUserEnumService;
import top.it6666.template.SaveUpdateDBTemplate;
import top.it6666.utils.DBResultUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author BNTang
 * @since 2022-12-03
 */
@Service
public class UserEnumServiceImpl extends ServiceImpl<UserEnumMapper, UserEnum>
        implements IUserEnumService, SaveUpdateDBTemplate<UserEnum> {

    @Resource
    private UserEnumMapper userEnumMapper;

    @Override
    public int batchUpdate(List<UserEnum> elements) {
        int result = 0;
        for (UserEnum element : elements) {
            // todo: mp 存在一个问题，没有提供 service 的批量更新by id 的返回值为 int 类型的方法
            // 貌似mapper 层 选装件 可以解决该问题
            result += this.userEnumMapper.updateById(element);
        }
        return result;
    }

    @Override
    public int batchInsert(List<UserEnum> elements) {
        return DBResultUtil.doBoolToInt(saveBatch(elements));
    }

    @Override
    public void testUserEnum(UserEnum userEnum) {
        saveUpdate(CollUtil.newArrayList(userEnum));
    }

    @Override
    public List<UserEnum> getUserEnumList() {
        QueryWrapper<UserEnum> queryWrapper = new QueryWrapper<>();
        return list(queryWrapper);
    }

    @Override
    public List<Map<String, Object>> testPaging(Integer page, Integer pageSize) {
        Page<Map<String, Object>> pageObj = new Page<>(page, pageSize);
        IPage<Map<String, Object>> result = pageMaps(pageObj, null);

        return result.getRecords();
    }

    @Override
    public List<UserEnum> testMapperPaging(Integer page, Integer pageSize) {
        Page<UserEnum> objectPage = new Page<>(page, pageSize);
        this.userEnumMapper.selectPage(objectPage, null);
        return objectPage.getRecords();
    }
}