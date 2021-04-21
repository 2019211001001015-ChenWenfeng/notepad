package com.notepad.controller;

import com.notepad.pojo.Json;
import com.notepad.pojo.UnfinishClass;
import com.notepad.service.UnfinishClassService;
import com.notepad.utils.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.notepad.utils.JsonData.fail;
import static com.notepad.utils.JsonData.success;

@Api(tags={"待办分类的接口"})
@RestController
@RequestMapping("/unfinishClass")
public class UnfinishClassController {

    @Autowired
    private UnfinishClassService unfinishClassService;

//    新增待办分类
    @ApiOperation(value = "新增待办分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clas",value = "新增的类型",dataType = "string",paramType = "path",required = true),
            @ApiImplicitParam(name = "user_id",value = "用户的id",dataType = "int",paramType = "path",required = true)
    })

    @GetMapping("/addCla/{clas}/{user_id}")
    public Json addCla(@PathVariable String clas,@PathVariable int user_id)
    {
        int k = 0;
        List<Map<String,Object>> maps = unfinishClassService.findAll(user_id);
        for (Map map: maps) {

            if(map.containsValue(clas))
            {
                k = 1;
                break;
            }
        }
        if( k == 0)
        {
            unfinishClassService.add(user_id,clas);
            return success();
        }
        else
        {
            return fail();
        }


    }


//    查询出所有待办分类信息
    @ApiOperation(value = "查询出所有待办分类")
    @ApiImplicitParam(name = "user_id",value = "用户的id",dataType = "int",paramType = "path",required = true)
    @GetMapping("/findAllCla/{user_id}")

    public Json<UnfinishClass> findAllCla(@PathVariable int user_id)
    {
        List<Map<String,Object>> unfinishClasses = unfinishClassService.findAll(user_id);

        if(unfinishClasses.isEmpty())
        {
           return fail();
        }else
        {

            return success(unfinishClasses);
        }

    }




}
