package top.it6666.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.it6666.entity.User;
import top.it6666.pojo.ResultBody;
import top.it6666.service.IUserService;

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

    @PostMapping("/testSaveUpdate")
    @ApiOperation("保存或更新")
    ResultBody<Void> testSaveUpdate(@RequestBody User user) {
        this.userService.saveUpdate(user);
        return ResultBody.success();
    }
}