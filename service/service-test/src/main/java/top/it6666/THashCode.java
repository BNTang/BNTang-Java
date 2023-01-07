package top.it6666;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

/**
 * @author BNTang
 * @version 1.0
 * @description
 * @since 2023-16-07
 **/
public class THashCode {

    /**
     * 狗
     *
     * @author BNTang
     * @date 2023/01/07
     */
    @Getter
    @Setter
    static class Dog implements Cloneable {
        private String name;
        private Integer age;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.hashCode());

        System.out.println(THashCodeIsReq(dog));

        Dog clone = (Dog) dog.clone();
        System.out.println(clone.hashCode());
    }

    public static Integer THashCodeIsReq(Dog dog) {
        return dog.hashCode();
    }
}
