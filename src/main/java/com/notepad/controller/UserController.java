package com.notepad.controller;


import com.notepad.pojo.Json;
import com.notepad.pojo.User;
import com.notepad.pojo.WXSessionModel;
import com.notepad.service.UserService;
import com.notepad.utils.HttpClientUtil;
import com.notepad.utils.JsonUtils;
import com.notepad.utils.LoginUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.notepad.utils.JsonData.fail;
import static com.notepad.utils.JsonData.success;
import static com.notepad.utils.LoginUtils.getUrl;

@CrossOrigin
@Api(tags={"用户的接口"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/login/{code}")
    @ApiImplicitParam(name="code",value = "用户的code",dataType = "String",paramType = "path",required = true)
    @ApiOperation("登录功能")
//    登录方法
    public Json<User> login(@PathVariable String code,@RequestBody User user){
        Map<String, String> param = new HashMap<String, String>();
        param.put("appid", "wxf3db388fca705614");
        param.put("secret", "b103f4ded749c94f84ea5304bfacb0bb");
        param.put("grant_type", "authorization_code");
        param.put("js_code", code);


        String wxResult = HttpClientUtil.doGet(getUrl(), param);
        WXSessionModel wxSessionModel = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);

        String openid = wxSessionModel.getOpenid();

        Map<String,String> result = new HashMap<>();
        result.put("openid",openid);
        result.put("code",code);


        User user1 = userService.find_openId(openid);
        if(user1 != null)
        {
//            老用户
            user1.setHead_portrait(user.getHead_portrait());
            user1.setUser_login_time(new Date());
//            这里可能会有问题
            userService.update(user1);
            return success(result);
        }else{

            // 新用户，添加到数据库
            user1.setUser_open_id(openid);
            user1.setUser_login_time(new Date());
            Boolean flag = userService.add(user);
            if(!flag){

                return fail();
            }

            return success(result);

        }

    }
}
