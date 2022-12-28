package top.it6666.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GradeEnum {
    PRIMARY(1,"小学"),
    SECONDORY(2,"中学"),
    HIGH(3,"高中");
    /**
     * 标记数据库存的值是code
     */
    @EnumValue
    private final int code;
    private final String desc;
}