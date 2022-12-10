package top.it6666.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.it6666.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}