package top.it6666.controller;

import cn.easyes.core.conditions.LambdaEsQueryWrapper;
import cn.easyes.core.toolkit.EsWrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.it6666.mapper.DocumentMapper;
import top.it6666.schema.Document;
import top.it6666.schema.ResultBody;

/**
 * @author BNTang
 * @version V1.0
 * @project BNTang-Java
 * @date Created in 2022/11/26 19:56
 * @description ee 条件构造器
 * 如果您之前已经有了解过MP的条件构造器,那我们建议您直接拉到文末,
 * 看一下index,enableMust2Filter,and&or这三项MP中没有的即可,其它与MP一致. Wrapper支持两种方式创建
 **/
@RestController
@RequestMapping("/eeQueryWrapper-controller")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class BNTangTestUseEeQueryWrapperController {

    private final DocumentMapper documentMapper;

    /**
     * 可通过wrapper.index(String indexName)指定本次查询作用于哪个索引,
     * 如果本次查询要从多个索引上查询,那么索引名称可以用逗号隔开,
     * 例如wrapper.index("index1","indexe2"...) wrapper中指定的索引名称优先级最高,
     * 如果不指定则取实体类中配置的索引名称,如果实体类也未配置,则取实体名称小写作为当前查询的索引名
     * 针对insert/delete/update等接口中无wrapper的情况,如果你需要指定索引名,
     * 可直接在对应接口的入参中添加索引名称,可参考下面示例
     */
    @GetMapping("/testIndex")
    ResultBody<Document> testIndex() {
        LambdaEsQueryWrapper<Document> queryWrapper = EsWrappers.lambdaQuery(Document.class);
        queryWrapper.index("document");
        queryWrapper.eq("title", "it6666");
        return ResultBody.result(this.documentMapper.selectOne(queryWrapper));
    }
}