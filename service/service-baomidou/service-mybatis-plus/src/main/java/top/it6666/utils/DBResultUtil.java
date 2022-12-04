package top.it6666.utils;

import lombok.experimental.UtilityClass;

/**
 * @author BNTang
 * @version V1.0
 **/
@UtilityClass
public class DBResultUtil {
    /**
     * 布尔类型转换为数值
     */
    public Integer doBoolToInt(Boolean bool) {
        return Boolean.TRUE.equals(bool) ? 1 : 0;
    }
}