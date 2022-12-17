package top.it6666.properties;

import lombok.Data;

/**
 * @author BNTang
 * @version 1.0
 * @since 2022-10-11
 **/
@Data
public class BNTangSwagger3Properties {
    /**
     * 基本包
     */
    private String basePackage;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 版本
     */
    private String version;
    /**
     * 作者
     */
    private String author;
    /**
     * url
     */
    private String url;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 许可证
     */
    private String license;
    /**
     * 许可证url
     */
    private String licenseUrl;
    /**
     * 路径
     */
    private String paths;
    /**
     * 组
     */
    private String group;
}