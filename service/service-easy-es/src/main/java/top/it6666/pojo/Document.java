package top.it6666.pojo;

import cn.easyes.annotation.IndexName;
import lombok.Data;

@Data
@IndexName(keepGlobalPrefix = true)
public class Document {
    /**
     * es中的唯一id
     */
    private String id;
    /**
     * 文档标题
     */
    private String title;
    /**
     * 文档内容
     */
    private String content;
}