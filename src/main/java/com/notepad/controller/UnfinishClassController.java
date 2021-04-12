package com.notepad.controller;

import com.notepad.pojo.Json;
import com.notepad.pojo.UnfinishClass;
import com.notepad.service.UnfinishClassService;
import com.notepad.utils.JsonData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unfinishClass")
public class UnfinishClassController {

    @Autowired
    private UnfinishClassService unfinishClassService;

//    新增待办分类
    @ApiOperation(value = "新增待办分类")
    @ApiImplicitParam(name = "clas",value = "新增的类型",dataType = "string",paramType = "path",required = true)
    @GetMapping("/addCla/{clas}")
    public Json addCla(@PathVariable String clas)
    {
        if(clas!= null)
        {
            unfinishClassService.add(clas);
            return new JsonData().success();
        }
        else
        {
            return new JsonData().fail();
        }


    }


//    查询出所有待办分类信息
    @GetMapping("/findAllCla")

    public List<UnfinishClass> findAllCla()
    {
        List<UnfinishClass> unfinishClasses = unfinishClassService.findAll();
        return unfinishClasses;
    }




}
