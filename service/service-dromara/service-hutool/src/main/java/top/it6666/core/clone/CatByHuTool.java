package top.it6666.core.clone;

import cn.hutool.core.clone.CloneRuntimeException;
import cn.hutool.core.clone.Cloneable;
import lombok.Data;

/**
 * @author BNTang
 * @version 1.0
 * @description
 * @since 2023-15-07
 **/
@Data
public class CatByHuTool implements Cloneable<CatByHuTool> {
    /**
     * 名字
     */
    private String name = "miaomiao";
    /**
     * 年龄
     */
    private int age = 2;

    @Override
    public CatByHuTool clone() {
        try {
            return (CatByHuTool) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneRuntimeException(e);
        }
    }
}