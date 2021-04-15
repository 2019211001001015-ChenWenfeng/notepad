package com.notepad.controller;

import com.notepad.mapper.UnfinishMapper;
import com.notepad.pojo.Json;
import com.notepad.pojo.Note;
import com.notepad.pojo.Unfinish;
import com.notepad.pojo.UnfinishClass;
import com.notepad.service.UnfinishClassService;
import com.notepad.service.UnfinishService;
import com.notepad.utils.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Api(tags={"待办的接口"})
@RestController
@RequestMapping("/unfinish")
public class UnfinishController {
    @Autowired
    private UnfinishService unfinishService;
    @Autowired
    private UnfinishClassService unfinishClassService;

//  添加待办
    @GetMapping("/add/{unfinish}")
    @ApiOperation(value = "添加待办")
    @ApiImplicitParam(name = "unfinish",value = "待办",dataType = "Unfinish",required = true)
    public Json<Unfinish> add(@PathVariable Unfinish unfinish)
    {
        int complete = 0;
        if(unfinish != null)
        {
            unfinish.setComplete(complete);
            unfinishService.add(unfinish);
            return new JsonData().success(unfinish);

        }else{
            return new JsonData().fail();
        }

    }

//    查询出所有的待办
    @GetMapping("/findAll")
    @ApiOperation(value = "查询出所有待办")
    public List<Unfinish> findAll()
    {
        List<Unfinish> unfinishList = unfinishService.findAll();



        return unfinishList;
    }
//  查询出单个待办
    @GetMapping("/find/{id}")
    @ApiOperation(value = "查询出单个待办")
    @ApiImplicitParam(name = "id",value = "待办的id",dataType = "int",paramType = "path",required = true)
    public Json<Unfinish> find(@PathVariable int id)
    {
        Unfinish unfinish = unfinishService.find(id);
        if (unfinish != null)
        {
            return new JsonData().success(unfinish);
        }
        else {
            return new JsonData().fail();
        }


    }

//    给待办进行分类
    @GetMapping("/classify/{id}/{clas}")
    @ApiOperation(value = "给待办进行分类")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "待办的id",dataType = "int",paramType = "path",required = true),
            @ApiImplicitParam(name = "clas",value = "待办的类型",dataType = "string",paramType = "path",required = true)
    })
    public Json<Unfinish> classify(@PathVariable int id,@PathVariable String clas)
    {

        Unfinish unfinish = unfinishService.find(id);
        if(unfinish != null)
        {
            UnfinishClass unfinishClass = unfinishClassService.find_class(clas);
            unfinishService.update_id(id,unfinishClass.getUnfinish_class_id());
            unfinish = unfinishService.find(id);


            return new JsonData().success(unfinish);
        }else{
            return new JsonData().fail(unfinish);
        }




    }

    /**
     *  $.ajax({
     *               url:"http://112.74.175.68:8090/diary/" + id , // 请求路径
     *               type:"POST" , //请求方式
     *               //data: "username=jack&age=23",//请求参数
     *               data:{"username":"jack","age":23},
     *               success:function (data) {
     *               data.code
     *                   alert(data);
     *               },//响应成功后的回调函数
     *               error:function () {
     *                   alert("出错啦...")
     *               },//表示如果请求响应出现错误，会执行的回调函数
     *
     *               dataType:"text"//设置接受到的响应数据的格式
     *           });

     */

}
