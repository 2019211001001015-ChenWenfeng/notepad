package com.notepad.controller;


import com.notepad.pojo.Json;
import com.notepad.pojo.User;
import com.notepad.pojo.WXSessionModel;
import com.notepad.service.UserService;
import com.notepad.utils.HttpClientUtil;
import com.notepad.utils.JsonUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.notepad.utils.JsonData.fail;
import static com.notepad.utils.JsonData.success;


@Api(tags={"用户的接口"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/login/{code}")
    @ApiOperation("登录功能")
    @ApiImplicitParam(name = "code" ,value = "微信的id",dataType = "String" ,paramType = "path",required = true)

//    登录方法
    public Json<User> login(@PathVariable String code,User user){
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<String, String>();
        param.put("appid", "wx2f2c7c617b0ae5f8");
        param.put("secret", "705bee5d5b0a3418bda834fc60c0ac8a");
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");

        String wxResult = HttpClientUtil.doGet(url, param);
        WXSessionModel wxSessionModel = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);

        String openid = wxSessionModel.getOpenid();

        User user1 = userService.find_openId(openid);
        if(user1 != null)
        {
//            老用户
            user1.setUser_login_time(new Date());
//            这里可能会有问题
            userService.update(user1);
            return success(user1);
        }else{

            // 新用户，添加到数据库
            Boolean flag = userService.add(user);
            if(!flag){

                return fail();
            }
            else
            {

                return success(user1);
            }

        }

    }
}
