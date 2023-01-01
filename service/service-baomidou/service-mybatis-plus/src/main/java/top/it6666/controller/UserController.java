package top.it6666.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.it6666.entity.User;
import top.it6666.entity.UserEnum;
import top.it6666.pojo.BNTangResultBody;
import top.it6666.service.IUserEnumService;
import top.it6666.service.IUserService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author BNTang
 * @since 2022-12-03
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
@Api(tags = "测试API接口")
public class UserController {
    private final IUserService userService;
    private final IUserEnumService iUserEnumService;

    @PostMapping("/testSaveUpdate")
    @ApiOperation("保存或更新")
    BNTangResultBody<Void> testSaveUpdate(@RequestBody User user) {
        this.userService.saveUpdate(user);
        return BNTangResultBody.success();
    }

    @PostMapping("/testUserEnum")
    @ApiOperation("删除或更新UserEnum")
    BNTangResultBody<Void> testUserEnum(@RequestBody UserEnum userEnum) {
        this.iUserEnumService.testUserEnum(userEnum);
        return BNTangResultBody.success();
    }

    @GetMapping("/getUserEnumList")
    @ApiOperation("获取所有UserEnum")
    BNTangResultBody<List<UserEnum>> getUserEnumList() {
        return BNTangResultBody.result(this.iUserEnumService.getUserEnumList());
    }

    @GetMapping("/testServicePaging/{page}/{pageSize}")
    BNTangResultBody<List<Map<String, Object>>> testPaging(@PathVariable Integer page, @PathVariable Integer pageSize) {
        return BNTangResultBody.result(this.iUserEnumService.testPaging(page, pageSize));
    }

    @GetMapping("/testMapperPaging/{page}/{pageSize}")
    BNTangResultBody<List<UserEnum>> testMapperPaging(@PathVariable Integer page, @PathVariable Integer pageSize) {
        return BNTangResultBody.result(this.iUserEnumService.testMapperPaging(page, pageSize));
    }
}