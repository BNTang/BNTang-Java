package top.it6666.core;

/**
 * @author BNTang
 * @version 1.0
 * @description
 * @since 2023-15-07
 **/
public class CatTest {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println("cat = " + cat);
        System.out.println(cat.hashCode());

        Cat clone = cat.clone();
        clone.setName("BNTang");
        System.out.println("clone = " + clone);
        System.out.println(clone.hashCode());
    }
}