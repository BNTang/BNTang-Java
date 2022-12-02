package top.it6666.pojo;

import lombok.Data;
@Data
public class Customer {
    /**
     * id
     */
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 地址
     */
    private String address;
    /**
     * 工资
     */
    private Integer salary;
}