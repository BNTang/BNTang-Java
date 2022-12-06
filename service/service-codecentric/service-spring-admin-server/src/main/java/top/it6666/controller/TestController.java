package top.it6666.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangyihao
 * @version SFO1.14.4Dev
 * @program BNTang-Java
 * @date Created in 2022/12/06 006 9:46
 * @description
 **/
@RestController
@RequestMapping("/top")
public class TestController {
    @GetMapping("/test1")
    public String test1() {
        return "success";
    }
}