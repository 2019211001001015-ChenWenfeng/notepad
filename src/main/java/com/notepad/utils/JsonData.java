package com.notepad.utils;

import com.notepad.pojo.Json;


public  class JsonData<T> {



    public static Json success(Object object)
    {
//        设置200为成功
        Json json = new Json();
        json.setMessage("成功了！！！");
        json.setCode(200);
        json.setData(object);
        return json;


    }

    public static Json success()
    {
//        设置200为成功
        Json json = new Json();
        json.setMessage("成功了！！！");
        json.setCode(200);
        return json;


    }

    public  static Json fail(Object object)
    {
//        设置500为失败
        Json json = new Json();
        json.setMessage("操作未执行成功！！！");
        json.setCode(500);
        json.setData(object);
        return json;


    }
    public static Json fail()
    {
//        设置500为失败
        Json json = new Json();
        json.setMessage("操作未执行成功！！！");
        json.setCode(500);

        return json;


    }
}
