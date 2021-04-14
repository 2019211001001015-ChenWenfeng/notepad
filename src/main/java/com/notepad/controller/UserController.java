package com.notepad.controller;


import com.notepad.pojo.User;
import com.notepad.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/login/{user}")
    @ApiOperation("登录功能")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id",value = "用户id",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "username",value = "用户名",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "head_portrait",value = "用户头像",dataType = "String",paramType = "path")
    })
    //登录方法
    public User login(@PathVariable String user_id,@PathVariable String username,@PathVariable String head_portrait, Model model){
        User user = new User(user_id, username, head_portrait);
        userService.add(user);
        model.addAttribute("user_id",user.getUser_id());
        System.out.println(user);
        return user;
    }
}
