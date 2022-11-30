package top.it6666.controller;

import cn.easyes.core.conditions.LambdaEsQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.it6666.mapper.DocumentMapper;
import top.it6666.pojo.Document;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(tags = "EE CRUD API 接口")
public class TestUseEeCRUDController {
    private final DocumentMapper documentMapper;

    @ApiOperation("插入数据")
    @GetMapping("/insert")
    public Integer insert() {
        // 初始化-> 新增数据
        Document document = new Document();
        document.setTitle("老汉");
        document.setContent("推*技术过硬");
        return this.documentMapper.insert(document);
    }

    @ApiOperation("查询数据")
    @GetMapping("/search")
    public List<Document> search() {
        // 查询出所有标题为老汉的文档列表
        LambdaEsQueryWrapper<Document> wrapper = new LambdaEsQueryWrapper<>();
        wrapper.eq(Document::getTitle, "老汉");
        return this.documentMapper.selectList(wrapper);
    }

    /**
     * 根据Id删除数据
     */
    @DeleteMapping("/deleteById/{id}")
    public Integer deleteById(@PathVariable String id) {
        return this.documentMapper.deleteById(id);
    }

    /**
     * 更新根据Id
     */
    @PutMapping("/update")
    public Integer update() {
        Document document = new Document();
        document.setId("D33Hs4QBNyDzYy-TJq35");
        document.setTitle("it6666");
        document.setContent("BNTang");
        return this.documentMapper.updateById(document);
    }
}