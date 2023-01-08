package top.it6666.core.clone;

import cn.hutool.core.util.ObjectUtil;

/**
 * @author BNTang
 * @version 1.0
 * @description
 * @since 2023-15-08
 **/
public class TObjectUtil {
    public static void main(String[] args) {
        testClone();
    }

    public static void testClone() {
        DogByDeepClone dogByDeepClone = new DogByDeepClone();
        System.out.println("dogByDeepClone.hashCode() = " + dogByDeepClone.hashCode());

        DogByDeepClone clone = ObjectUtil.clone(dogByDeepClone);
        System.out.println("clone.hashCode() = " + clone.hashCode());

        Student student = new Student();
        System.out.println("student = " + student);
        Student studentClone = ObjectUtil.clone(student);
        System.out.println(studentClone);

        Student cloneStudent = ObjectUtil.cloneIfPossible(student);
        System.out.println("cloneStudent = " + cloneStudent);
    }
}
