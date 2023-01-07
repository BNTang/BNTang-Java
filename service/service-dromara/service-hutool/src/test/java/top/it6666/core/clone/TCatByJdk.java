package top.it6666.core.clone;

import lombok.SneakyThrows;

/**
 * @author BNTang
 * @version 1.0
 * @description
 * @since 2023-15-07
 **/
public class TCatByJdk {
    @SneakyThrows
    public static void main(String[] args) {
        CatByJdk catByJdk = new CatByJdk();
        System.out.println("catByJdk = " + catByJdk);
        System.out.println(catByJdk.hashCode());

        CatByJdk clone = (CatByJdk) catByJdk.clone();
        clone.setName("BNTang");
        System.out.println("clone = " + clone);
        System.out.println(clone.hashCode());
    }
}