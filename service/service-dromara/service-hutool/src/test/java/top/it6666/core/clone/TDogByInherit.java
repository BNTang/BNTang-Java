package top.it6666.core.clone;

/**
 * @author BNTang
 * @version 1.0
 * @description
 * @since 2023-16-07
 **/
public class TDogByInherit {
    public static void main(String[] args) {
        DogByInherit dogByInherit = new DogByInherit();
        System.out.println("dogByInherit.hashCode() = " + dogByInherit.hashCode());

        DogByInherit clone = dogByInherit.clone();
        clone.setName("旺财");
        System.out.println(clone);
        System.out.println("clone.hashCode() = " + clone.hashCode());
    }
}