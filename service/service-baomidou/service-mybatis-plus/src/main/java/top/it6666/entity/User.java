package top.it6666.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author BNTang
 * @since 2022-12-03
 */
@Data
@TableName("user")
@ApiModel(value = "User对象", description = "用户实体类")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("邮箱")
    private String email;

    /**
     * mybatisplus 的逻辑删除
     * 说明:
     * 只对自动注入的 sql 起效:
     * 插入: 不作限制
     * 查找: 追加 where 条件过滤掉已删除数据,如果使用 wrapper.entity 生成的 where 条件也会自动追加该字段
     * 更新: 追加 where 条件防止更新到已删除数据,如果使用 wrapper.entity 生成的 where 条件也会自动追加该字段
     * 删除: 转变为 更新
     * 例如:
     * 删除: update user set deleted=1 where id = 1 and deleted=0
     * 查找: select id,name,deleted from user where deleted=0
     * 字段类型支持说明:
     * 支持所有数据类型(推荐使用 Integer,Boolean,LocalDateTime)
     * 如果数据库字段使用datetime,逻辑未删除值和已删除值支持配置为字符串null,另一个值支持配置为函数来获取值如now()
     * 附录:
     * 逻辑删除是为了方便数据恢复和保护数据本身价值等等的一种方案，但实际就是删除。
     * 如果你需要频繁查出来看就不应使用逻辑删除，而是以一个状态去表示。
     */
    //@TableLogic
    //private Integer deleted;
}