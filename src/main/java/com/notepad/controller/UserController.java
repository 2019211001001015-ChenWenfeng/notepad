package com.notepad.controller;


import com.notepad.pojo.User;
import com.notepad.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@Api(tags={"用户的接口"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    @ApiOperation("登录功能")
    //登录方法
    public boolean login(User user, Model model){
        boolean login = userService.login(user);
        if (login){
            model.addAttribute("user",user);
        }
        return login;
    }
}
