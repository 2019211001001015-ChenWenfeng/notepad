package com.notepad.controller;


import com.notepad.pojo.Json;
import com.notepad.pojo.NoteClass;
import com.notepad.pojo.UnfinishClass;
import com.notepad.service.NoteClassService;
import com.notepad.service.NoteService;
import com.notepad.utils.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags={"笔记分类的接口"})
@RestController
@RequestMapping("/noteClass")
public class NoteClassController {

    @Autowired
    private NoteClassService noteClassService;
    //    新增笔记分类
    @ApiOperation(value = "新增笔记分类")
    @ApiImplicitParam(name = "clas",value = "新增的类型",dataType = "string",paramType = "path",required = true)
    @GetMapping("/add/Cla{clas}")
    public Json addCla(@PathVariable String clas)
    {
        int k = 0;
        List<Map<String,Object>> maps = noteClassService.find_name();
        for (Map map: maps) {

            if(map.containsValue(clas))
            {
                k = 1;
                break;
            }
        }
        if( k == 0)
        {
            noteClassService.add(clas);
            return new JsonData().success();
        }
        else
        {
            return new JsonData().fail();
        }

    }


    //    查询出所有笔记分类信息
    @ApiOperation(value = "查询出所有笔记分类")
    @GetMapping("/findAllCla")

    public Json<NoteClassService> findAllCla() {
        List<NoteClass> noteClasses = noteClassService.findAll();
        if (noteClasses != null) {
            return new JsonData().success(noteClasses);
        } else {
            return new JsonData().fail();
        }
    }


}
