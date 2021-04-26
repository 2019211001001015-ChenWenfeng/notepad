package com.notepad.controller;


import com.notepad.pojo.*;
import com.notepad.service.NoteClassService;
import com.notepad.service.NoteService;
import com.notepad.service.UserService;
import com.notepad.utils.JsonData;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static com.notepad.utils.JsonData.fail;
import static com.notepad.utils.JsonData.success;

@CrossOrigin
@RestController
@RequestMapping("/note")
@Api(tags={"笔记的接口"})
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteClassService noteClassService;

    @Autowired
    private UserService userService;

    @ApiOperation("笔记置顶功能的设置")
    @PostMapping("/setTop/{note_id}")
    @ApiImplicitParam(name = "note_id",value = "笔记序号",dataType = "int",paramType = "path",required = true)
    public void noteSetTop(@PathVariable int note_id,Model model){
        noteService.noteSetTop(note_id);
    }


    @ApiOperation("笔记删除到回收站功能")
    @PostMapping("/delete/{note_id}")
    @ApiImplicitParam(name = "note_id",value = "笔记序号",dataType = "int",paramType = "path",required = true)
    public void deleteToRecover(@PathVariable int note_id){
        noteService.deleteToRecover(note_id);
    }

    @ApiOperation("笔记搜索功能")
    @PostMapping("/search/{user_id}/{thing}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id",value = "用户序号",dataType = "int",paramType = "path",required = true),
            @ApiImplicitParam(name = "thing",value = "搜索内容",dataType = "string",paramType = "path",required = true)
    })
    public List<Note> search(@PathVariable int user_id, @PathVariable String thing){
        List<Note> noteList = noteService.search(user_id, thing);
        System.out.println(noteList);
        return noteList;
    }
    //    查询出所有的笔记
    @GetMapping("/findAll/{user_id}")
    @ApiOperation(value = "查询出所有笔记")
    @ApiImplicitParam(name="user_id",value = "用户的id",dataType = "int",paramType = "path",required = true)
    public Json<Unfinish> findAll(@PathVariable int user_id)
    {


        if(userService.find(user_id) != null)
        {
            List<Note> notes = noteService.findAll(user_id);
            return success(notes);

        }
        else{
            return fail();
        }
    }

    //  查询出单个笔记
    @GetMapping("/find/{id}")
    @ApiOperation(value = "查询出单个笔记")
    @ApiImplicitParam(name = "id",value = "笔记的id",dataType = "int",paramType = "path",required = true)
    public Json<Unfinish> find(@PathVariable int id)
    {
        Note note = noteService.find(id);
        if (note != null)
        {
            return success(note);
        }
        else {
            return fail();
        }
    }


    //    给待办进行分类
    @GetMapping("/classify/{id}/{clas}")
    @ApiOperation(value = "给笔记进行分类")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "笔记的id",dataType = "int",paramType = "path",required = true),
            @ApiImplicitParam(name = "clas",value = "笔记的类型",dataType = "string",paramType = "path",required = true)
    })
    public Json<Unfinish> classify(@PathVariable int id,@PathVariable String clas)
    {

        Note note = noteService.find(id);
        if(note != null)
        {
            NoteClass noteClass = noteClassService.find_class(clas);
            noteService.update_id(id,noteClass.getNote_class_id());
            note = noteService.find(id);


            return success(note);
        }else{
            return fail(note);
        }




    }

    @ApiOperation(value = "笔记收藏")
    @ApiImplicitParam(name = "id",value = "笔记的id",dataType = "int",paramType = "path",required = true)
    @GetMapping("/collect/{id}")
    public Json<Note> collect(@PathVariable int id)
    {

       Note note = noteService.find(id);
        if(note != null)
        {
            int collect = noteService.find_collect(id);

            if(collect == 0)
            {
                collect = 1;
                noteService.update_collect(id,collect);

            }else{
                collect = 0;
                noteService.update_collect(id,collect);
            }
            note = noteService.find(id);
            return success(note);
        }else{
            return fail();
        }



    }


}
