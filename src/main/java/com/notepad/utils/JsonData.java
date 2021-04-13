package com.notepad.utils;

import com.notepad.pojo.Json;
import org.springframework.beans.factory.annotation.Autowired;

public class JsonData {



    public Json success(Object object)
    {
//        设置200为成功
        Json json = new Json();
        json.setMessage("成功了！！！");
        json.setCode(200);
        json.setData(object);
        return json;


    }

    public Json success()
    {
//        设置200为成功
        Json json = new Json();
        json.setMessage("成功了！！！");
        json.setCode(200);
        return json;


    }

    public Json fail(Object object)
    {
//        设置500为失败
        Json json = new Json();
        json.setMessage("操作未执行成功！！！");
        json.setCode(500);
        json.setData(object);
        return json;


    }
    public Json fail()
    {
//        设置500为失败
        Json json = new Json();
        json.setMessage("操作未执行成功！！！");
        json.setCode(500);

        return json;


    }
}
