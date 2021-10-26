package com.happygeniubi.ssmdemo.controller;

import com.happygeniubi.ssmdemo.domain.User;
import com.happygeniubi.ssmdemo.service.UserService;
import com.happygeniubi.ssmdemo.utils.JsonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/pub/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public JsonData login(@RequestBody User user) {
        log.info("登录成功,用户信息:{}", user);
        String token = userService.login(user.getUsername(), user.getPassword());
        return token != null ? JsonData.buildSuccess(token) : JsonData.buildError("帐号或密码错误");
    }

    @GetMapping("list")
    public JsonData userList() {
        List<User> userList = userService.userList();
        log.info("用户List:{}", userList);
        return JsonData.buildSuccess(userList);
    }
}
