package top.it6666.core.clone;

import cn.hutool.core.util.ObjectUtil;

/**
 * @author BNTang
 * @version 1.0
 * @description
 * @since 2023-15-08
 **/
public class TDogByDeepClone {
    public static void main(String[] args) {
        DogByDeepClone dogByDeepClone = new DogByDeepClone();
        System.out.println("dogByDeepClone = " + dogByDeepClone);
        System.out.println("dogByDeepClone.hashCode() = " + dogByDeepClone.hashCode());

        DogByDeepClone clone = ObjectUtil.cloneByStream(dogByDeepClone);
        System.out.println("clone = " + clone);
        System.out.println("clone.hashCode() = " + clone.hashCode());
    }
}
