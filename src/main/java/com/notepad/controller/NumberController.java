package com.notepad.controller;

import com.notepad.service.NumberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/number")
@Api(tags={"数量的接口"})
public class NumberController {

    @Autowired
    private NumberService numberService;

    @PostMapping("/findAllNoteNumber/{user_id}")
    @ApiOperation(value = "查询出所有笔记相关数量")
    @ApiImplicitParam(name="user_id",value = "用户的id",dataType = "int",paramType = "path",required = true)
    public String findAllNoteNumber(@PathVariable int user_id){
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> noteNumber = numberService.findNoteNumber(user_id);
        Map<String, Integer> noteClassNumber = numberService.findNoteClassNumber(user_id);
        map.putAll(noteNumber);
        map.putAll(noteClassNumber);
        return map.toString();
    }

    @PostMapping("/findAllUnfinishNumber/{user_id}")
    @ApiOperation(value = "查询出所有待办相关数量")
    @ApiImplicitParam(name="user_id",value = "用户的id",dataType = "int",paramType = "path",required = true)
    public String findAllUnfinishNumber(@PathVariable int user_id){
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> unfinishNumber = numberService.findUnfinishNumber(user_id);
        Map<String, Integer> unfinishClassNumber = numberService.findUnfinishClassNumber(user_id);
        map.putAll(unfinishNumber);
        map.putAll(unfinishClassNumber);
        return map.toString();
    }


    @PostMapping("/findAllNoteClassNumber/{user_id}")
    @ApiOperation(value = "查询出所有笔记分类相关数量")
    @ApiImplicitParam(name="user_id",value = "用户的id",dataType = "int",paramType = "path",required = true)
    public String findAllNoteClassNumber(@PathVariable int user_id){
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> noteClassNumber = numberService.findNoteClassNumber(user_id);
        map.putAll(noteClassNumber);
        return map.toString();
    }

    @PostMapping("/findAllUnfinishClassNumber/{user_id}")
    @ApiOperation(value = "查询出所有待办分类相关数量")
    @ApiImplicitParam(name="user_id",value = "用户的id",dataType = "int",paramType = "path",required = true)
    public String findAllUnfinishClassNumber(@PathVariable int user_id){
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> unfinishClassNumber = numberService.findUnfinishClassNumber(user_id);
        map.putAll(unfinishClassNumber);
        return map.toString();
    }

}
