package com.notepad.controller;


import com.notepad.pojo.Json;
import com.notepad.pojo.NoteClass;
import com.notepad.service.NoteClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.notepad.utils.JsonData.fail;
import static com.notepad.utils.JsonData.success;

@Api(tags={"笔记分类的接口"})
@RestController
@RequestMapping("/noteClass")
public class NoteClassController {

    @Autowired
    private NoteClassService noteClassService;
    //    新增笔记分类
    @ApiOperation(value = "新增笔记分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clas",value = "新增的类型",dataType = "string",paramType = "path",required = true),
            @ApiImplicitParam(name = "user_id",value = "用户的id",dataType = "string",paramType = "path",required = true)
    })

    @GetMapping("/addCla/{clas}/{user_id}")
    public Json addCla(@PathVariable String clas,@PathVariable String user_id)
    {
        int k = 0;
        List<Map<String,Object>> maps = noteClassService.findAll(user_id);
        for (Map map: maps) {

            if(map.containsValue(clas))
            {
                k = 1;
                break;
            }
        }
        if( k == 0)
        {
            noteClassService.add(user_id,clas);
            return success();
        }
        else
        {
            return fail();
        }

    }


    //    查询出所有笔记分类信息
    @ApiOperation(value = "查询出所有笔记分类")
    @GetMapping("/findAllCla/{user_id}")
    @ApiImplicitParam(name = "user_id",value = "用户的id",dataType = "String" ,paramType = "path",required = true)

    public Json<NoteClassService> findAllCla(@PathVariable String user_id) {

        List<Map<String,Object>> noteClasses = noteClassService.findAll(user_id);
        if (noteClasses.isEmpty()) {
            return fail();
        } else {
            return success(noteClasses);
        }
    }


}
