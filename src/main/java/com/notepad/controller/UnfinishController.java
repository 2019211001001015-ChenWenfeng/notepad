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

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.notepad.utils.JsonData.fail;
import static com.notepad.utils.JsonData.success;

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
            return success(unfinish);

        }else{
            return fail();
        }

    }

//    查询出所有的待办
    @GetMapping("/findAll/{user_id}")
    @ApiOperation(value = "查询出所有待办")
    @ApiImplicitParam(name="user_id",value = "用户的id",dataType = "string",paramType = "path",required = true)
    public Json<Unfinish> findAll(@PathVariable String user_id)
    {
        if(user_id != null)
        {

            return success(unfinishService.findAll(user_id));

        }
        else{
            return fail();
        }




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
            return success(unfinish);
        }
        else {
            return fail();
        }



    }

//    给待办进行分类
    @GetMapping("/classify/{id}/{clas}")
    @ApiOperation(value = "给待办进行分类")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "待办的id",dataType = "int",paramType = "path",required = true),
            @ApiImplicitParam(name = "clas",value = "待办的类型",dataType = "string",paramType = "path",required = true)
    })
    public Json<Unfinish> classify(@PathVariable int id,@PathVariable String clas) {

        Unfinish unfinish = unfinishService.find(id);
        if (unfinish != null) {
            UnfinishClass unfinishClass = unfinishClassService.find_class(clas);
            unfinishService.update_id(id, unfinishClass.getUnfinish_class_id());
            unfinish = unfinishService.find(id);


            return success(unfinish);
        } else {
            return fail();
        }
    }

    @ApiOperation("待办置顶功能的设置")
    @PostMapping("/setTop/{unfinish_id}")
    @ApiImplicitParam(name = "unfinish_id",value = "待办序号",dataType = "int",paramType = "path",required = true)
    public String noteSetTop(@PathVariable int unfinish_id,Model model){
        unfinishService.unfinishSetTop(unfinish_id);
        Unfinish unfinish = unfinishService.find(unfinish_id);
        return unfinish.toString();//到时候在修改
    }


    @ApiOperation("待办删除到回收站功能")
    @PostMapping("/delete/{unfinish_id}")
    @ApiImplicitParam(name = "unfinish_id",value = "待办序号",dataType = "int",paramType = "path",required = true)
    public String deleteToRecover(@PathVariable int unfinish_id){
        unfinishService.deleteToRecover(unfinish_id);
        Unfinish unfinish = unfinishService.find(unfinish_id);
        return unfinish.toString();//到时候在修改
    }


    @ApiOperation("待办完成功能")
    @PostMapping("/complete/{unfinish_id}")
    @ApiImplicitParam(name = "unfinish_id",value = "待办序号",dataType = "int",paramType = "path",required = true)
    public String complete(@PathVariable int unfinish_id){
        unfinishService.complete(unfinish_id);
        Unfinish unfinish = unfinishService.find(unfinish_id);
        return unfinish.toString();//到时候在修改
        //        System.out.println("置顶时间"+unfinish.getComplete());
    }


    @ApiOperation("待办搜索功能")
    @PostMapping("/search/{user_id}/{thing}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id",value = "用户序号",dataType = "string",paramType = "path",required = true),
            @ApiImplicitParam(name = "thing",value = "搜索内容",dataType = "string",paramType = "path",required = true)
    })
    public List<Unfinish> search(@PathVariable String user_id , @PathVariable String thing){
        return unfinishService.search(user_id,thing);
    }




    @ApiOperation(value = "待办收藏")
    @ApiImplicitParam(name = "id",value = "待办的id",dataType = "int",paramType = "path",required = true)
    @GetMapping("/collect/{id}")
    public Json<Unfinish> collect(@PathVariable int id)
    {

          Unfinish unfinish = unfinishService.find(id);
          if(unfinish != null)
          {
             int collect = unfinishService.find_collect(id);

             if(collect == 0)
             {
                collect = 1;
                unfinishService.update_collect(id,collect);

             }else{
                 collect = 0;
                 unfinishService.update_collect(id,collect);
             }
             unfinish = unfinishService.find(id);
             return success(unfinish);
          }else{
              return fail();
          }



    }

}
