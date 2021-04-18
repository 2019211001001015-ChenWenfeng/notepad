package com.notepad.controller;
import com.notepad.pojo.Json;
import com.notepad.pojo.Unfinish;
import com.notepad.pojo.UnfinishClass;
import com.notepad.service.UnfinishClassService;
import com.notepad.service.UnfinishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public Json<Unfinish> classify(@PathVariable int id,@PathVariable String clas)
    {

        Unfinish unfinish = unfinishService.find(id);
        if(unfinish != null)
        {
            UnfinishClass unfinishClass = unfinishClassService.find_class(clas);
            unfinishService.update_id(id,unfinishClass.getUnfinish_class_id());
            unfinish = unfinishService.find(id);


            return success(unfinish);
        }else{
            return fail();
        }




    }


//    //    新增待办分类
//    @ApiOperation(value = "待办收藏")
//    @ApiImplicitParam(name = "id",value = "待办的id",dataType = "int",paramType = "path",required = true)
//    @GetMapping("/collect/{id}")
//    public Json<Unfinish> collect(@PathVariable int id)
//    {
//
//          Unfinish unfinish = unfinishService.find(id);
//          if(unfinish != null)
//          {
//
//          }
//          else{
//              return  success();
//          }
//
//    }


}
