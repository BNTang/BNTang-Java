package top.it6666;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.it6666.mapper.DocumentMapper;
import top.it6666.pojo.Document;

import javax.annotation.Resource;

@SpringBootTest(classes = ServiceEasyEsApp.class)
class EECRUDTest {

    @Resource
    private DocumentMapper documentMapper;

    @Test
    void testInsert() {
        // 测试插入数据
        Document document = new Document();
        document.setTitle("老汉");
        document.setContent("推*技术过硬");

        int successCount = this.documentMapper.insert(document);
        System.out.println(successCount);
    }
}