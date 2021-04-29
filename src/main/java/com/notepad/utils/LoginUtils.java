package com.notepad.utils;

import java.util.HashMap;
import java.util.Map;

public class LoginUtils {

    public static String getUrl()
    {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        return url;
    }

    public static Map<String,String> getParam()
    {
        Map<String, String> param = new HashMap<String, String>();
        param.put("appid", "wxf3db388fca705614");
        param.put("secret", "b103f4ded749c94f84ea5304bfacb0bb");
        param.put("grant_type", "authorization_code");

        return param;
    }



}
