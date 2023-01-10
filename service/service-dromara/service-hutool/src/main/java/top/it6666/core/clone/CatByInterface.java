package top.it6666.core.clone;

import cn.hutool.core.clone.CloneRuntimeException;
import cn.hutool.core.clone.Cloneable;
import lombok.Data;

/**
 * @author BNTang
 * @version 1.0
 * @description 泛型克隆接口
 * @since 2023-15-07
 **/
@Data
public class CatByInterface implements Cloneable<CatByInterface> {
    /**
     * 名字
     */
    private String name = "miaomiao";
    /**
     * 年龄
     */
    private int age = 2;

    @Override
    public CatByInterface clone() {
        try {
            return (CatByInterface) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneRuntimeException(e);
        }
    }
}