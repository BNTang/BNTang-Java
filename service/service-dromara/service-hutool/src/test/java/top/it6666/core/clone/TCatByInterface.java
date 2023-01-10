package top.it6666.core.clone;

/**
 * @author BNTang
 * @version 1.0
 * @description 测试 HuTool 泛型克隆接口
 * @since 2023-15-07
 **/
public class TCatByInterface {
    public static void main(String[] args) {
        CatByInterface cat = new CatByInterface();
        System.out.println("cat = " + cat);
        System.out.println(cat.hashCode());

        CatByInterface clone = cat.clone();
        clone.setName("BNTang");
        System.out.println("clone = " + clone);
        System.out.println(clone.hashCode());
    }
}