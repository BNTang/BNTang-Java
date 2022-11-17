package top.it6666.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import top.it6666.pojo.Test;

/**
 * 测试控制器
 *
 * @author BNTang
 * @date 2021/10/25
 */
@RestController
@RequestMapping("/swagger/test")
@Api(tags = "测试API接口")
public class TestController {

    @GetMapping("/getList")
    @ApiOperation(value = "获取列表数据", notes = "获取列表下测试数据")
    public String list() {
        return "查询列表数据!";
    }

    @GetMapping("{id}")
    @ApiOperation(value = "获取ID数据", notes = "根据ID获取某条测试数据")
    @ApiImplicitParam(name = "id", value = "主键id", paramType = "path", required = true)
    public String find(@PathVariable Integer id) {
        return String.format("根据主键查询数据: %d", id);
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增数据")
    @ApiParam(name = "test", value = "添加的测试模型实体")
    public String add(@RequestBody Test test) {
        return "插入数据!";
    }

    @PutMapping("{id}")
    @ApiOperation(value = "更新数据", notes = "根据ID更新测试数据")
    @ApiImplicitParam(name = "id", value = "主键id", paramType = "path", required = true)
    public String update(@PathVariable Integer id,
                         @ApiParam(name = "test", value = "更新的测试模型实体") @RequestBody Test test) {
        return String.format("根据主键更新一条记录: %d", id);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除数据", notes = "根据ID删除测试数据")
    @ApiImplicitParam(name = "id", value = "主键id", paramType = "path", required = true)
    public String delete(@PathVariable Integer id) {
        return String.format("根据主键删除记录: %d", id);
    }
}