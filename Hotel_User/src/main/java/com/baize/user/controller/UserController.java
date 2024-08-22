package com.baize.user.controller;

import com.baize.model.dto.UserDTO;
import com.baize.model.result.JsonRequest;
import com.baize.user.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //    用户注册
    @PostMapping("/register")
    public JsonRequest register(@RequestBody UserDTO userDTO) {
        return JsonRequest.success(userService.registerUser(userDTO));
    }

    //    用户登录
    public void login() {

    }

    //    用户注销
    public void logout() {

    }

    //    用户信息修改
    public void updateUserInfo() {
    }

    //    用户信息查询
    public void getUserInfo() {
    }

    //    用户密码修改
    public void updateUserPassword() {
    }
//    用户头像修改

}
