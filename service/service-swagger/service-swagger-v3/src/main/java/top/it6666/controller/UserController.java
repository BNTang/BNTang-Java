package top.it6666.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.it6666.entity.User;

@Tag(name = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getOneUser")
    @Operation(summary = "随机获取一个用户")
    public User getOneUser() {
        return new User("姓名", "13899999999");
    }
}
