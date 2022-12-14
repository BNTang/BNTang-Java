package top.it6666.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.it6666.pojo.ResultBody;

@Tag(name = "首页模块")
@RestController
public class IndexController {
    @Parameter(name = "name", description = "姓名", required = true)
    @Operation(summary = "向客人问好")
    @GetMapping("/sayHi")
    public ResponseEntity<String> sayHi(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok("Hi:" + name);
    }

    /**
     * 功能描述:swagger-get请求参数接口 示例
     *
     * @param name      name
     * @param pageIndex pageIndex
     * @param pageSize  pageSize
     **/
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "string", defaultValue = "张三", required = false),
            @ApiImplicitParam(name = "pageIndex", value = "页码", dataType = "int", defaultValue = "1", required = false),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", dataType = "int", defaultValue = "10", required = false)
    })
    @ApiOperation(value = "swagger-get请求参数接口", notes = "支持多条件查询", httpMethod = "GET")
    @GetMapping(value = "/swagger-get-api-multi-param")
    public ResultBody<Void> api1(@RequestParam(defaultValue = "0", required = false) int name,
                                 @RequestParam(defaultValue = "1", required = false) int pageIndex,
                                 @RequestParam(defaultValue = "10", required = false) int pageSize) {
        return ResultBody.success();
    }
}