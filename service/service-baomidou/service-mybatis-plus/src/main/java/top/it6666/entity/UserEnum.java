package top.it6666.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.it6666.enums.AgeEnum;
import top.it6666.enums.GradeEnum;

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
@TableName("user_enum")
@ApiModel(value = "User对象2", description = "用户实体类2")
public class UserEnum implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty("主键ID")
    private Long id;

    @TableField("name")
    @ApiModelProperty("姓名")
    private String name;

    /**
     * 年龄，IEnum接口的枚举处理
     * 数据库字段：age INT(3)
     */
    @TableField("age")
    @ApiModelProperty("年龄")
//    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private AgeEnum age;

    @TableField("email")
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 年级，原生枚举（带{@link com.baomidou.mybatisplus.annotation.EnumValue}):
     * 数据库字段：grade INT(2)
     */
    @TableField("grade")
//    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private GradeEnum grade;
}