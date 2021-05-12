package com.notepad.controller;

import com.notepad.mapper.UnfinishMapper;
import com.notepad.pojo.*;
import com.notepad.service.UnfinishClassService;
import com.notepad.service.UnfinishService;
import com.notepad.service.UserService;
import com.notepad.utils.HttpClientUtil;
import com.notepad.utils.JsonData;
import com.notepad.utils.JsonUtils;
import com.notepad.utils.LoginUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


import static com.notepad.utils.JsonData.fail;
import static com.notepad.utils.JsonData.success;
import static com.notepad.utils.LoginUtils.getUrl;

@CrossOrigin
@Api(tags={"待办的接口"})
@RestController
@RequestMapping("/unfinish")
public class UnfinishController {
    @Autowired
    private UnfinishService unfinishService;
    @Autowired
    private UnfinishClassService unfinishClassService;

    @Autowired
    private UserService userService;

//  添加待办
    @GetMapping("/add")
    @ApiOperation(value = "添加待办")
    @ApiImplicitParam(value = "code",name = "用户的code",dataType = "String",paramType = "path",required = true)
    public Json<Unfinish> add(@PathVariable String code,Unfinish unfinish)
    {
        Map<String, String> param;
        param = LoginUtils.getParam();
        param.put("js_code", code);


        String wxResult = HttpClientUtil.doGet(getUrl(), param);
        WXSessionModel wxSessionModel = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);

        String openid = wxSessionModel.getOpenid();

         User user = userService.find_openId(openid);
         unfinish.setUser_id(user.getUser_id());


        if(unfinish != null)
        {

            unfinishService.add(unfinish);
            return success(unfinish);

        }else{
            return fail();
        }

    }

//    查询出所有的待办
    @GetMapping("/findAll/{user_id}")
    @ApiOperation(value = "查询出所有待办")
    @ApiImplicitParam(name="user_id",value = "用户的id",dataType = "int",paramType = "path",required = true)
    public Json<Unfinish> findAll(@PathVariable int user_id)
    {
        User user = userService.find(user_id);


        if(user != null)
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
    @GetMapping("/setTop/{unfinish_id}")
    @ApiImplicitParam(name = "unfinish_id",value = "待办序号",dataType = "int",paramType = "path",required = true)
    public Json<Unfinish> noteSetTop(@PathVariable int unfinish_id){
        unfinishService.unfinishSetTop(unfinish_id);
        Unfinish unfinish = unfinishService.find(unfinish_id);
        if (unfinish!=null){
            return success(unfinish);//到时候在修改
        }else {
            return fail();
        }

    }


    @ApiOperation("待办删除到回收站功能")
    @GetMapping("/delete/{unfinish_id}")
    @ApiImplicitParam(name = "unfinish_id",value = "待办序号",dataType = "int",paramType = "path",required = true)
    public Json<Unfinish> deleteToRecover(@PathVariable int unfinish_id){
        unfinishService.deleteToRecover(unfinish_id);
        Unfinish unfinish = unfinishService.find(unfinish_id);
        if (unfinish!=null){
            return success(unfinish);
        }else {
            return fail();
        }
    }


    @ApiOperation("待办完成功能")
    @GetMapping("/complete/{unfinish_id}")
    @ApiImplicitParam(name = "unfinish_id",value = "待办序号",dataType = "int",paramType = "path",required = true)
    public Json<Unfinish> complete(@PathVariable int unfinish_id){
        unfinishService.complete(unfinish_id);
        Unfinish unfinish = unfinishService.find(unfinish_id);
        if (unfinish!=null){
            return success(unfinish);
        }
        return fail();
        //到时候在修改
        //        System.out.println("置顶时间"+unfinish.getComplete());
    }


    @ApiOperation("待办搜索功能")
    @GetMapping("/search/{user_id}/{thing}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id",value = "用户的序号",dataType = "string",paramType = "path",required = true),
            @ApiImplicitParam(name = "thing",value = "搜索内容",dataType = "string",paramType = "path",required = true)
    })
    public Json<Unfinish> search(@PathVariable int user_id , @PathVariable String thing){
        List<Unfinish> unfinishList = unfinishService.search(user_id, thing);
        if (unfinishList!=null){
            return success(unfinishList);
        }
        return fail();
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
