package com.notepad.controller;


import com.notepad.pojo.*;
import com.notepad.service.NoteClassService;
import com.notepad.service.NoteService;
import com.notepad.utils.JsonData;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/note")
@Api(tags={"笔记的接口"})
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteClassService noteClassService;

    @ApiOperation("置顶功能的设置")
    @PostMapping("/setTop/{note_id}")
    @ApiImplicitParam(name = "note_id",value = "笔记序号",dataType = "int",paramType = "path",required = true)
    public void setTop(@PathVariable int note_id,Model model){
//        System.out.println(note_id);
        Note note = noteService.find(note_id);
        if (note.getTop_time()!=null){
            note.setTop_time(null);
        }else {
            note.setTop_time(new Date());
        }
        noteService.update(note);
//        List<Note> noteList = noteService.findAll("1010");
//        System.out.println("置顶时间"+note.getTop_time());
//        return noteList.toString();//到时候在修改
    }


    @ApiOperation("删除功能")
    @PostMapping("/delete/{note_id}")
    @ApiImplicitParam(name = "note_id",value = "笔记序号",dataType = "int",paramType = "path",required = true)
    public String delete(@PathVariable int note_id){
        System.out.println(note_id);
        Note note = noteService.find(note_id);
        if (note.getDelete_time()!=null){
            note.setDelete_time(null);
        }else {
            note.setDelete_time(new Date());
        }
        noteService.update(note);
        List<Note> noteList = noteService.findAll("1010");
        System.out.println("删除时间"+note.getDelete_time());
        return noteList.toString();//到时候在修改
    }




    //    查询出所有的笔记
    @GetMapping("/findAll/{user_id}")
    @ApiOperation(value = "查询出所有笔记")
    @ApiImplicitParam(name="user_id",value = "用户的id",dataType = "string",paramType = "path",required = true)
    public Json<Unfinish> findAll(@PathVariable String user_id)
    {
        if(user_id != null)
        {
            List<Note> notes = noteService.findAll(user_id);
            return new JsonData().success(notes);

        }
        else{
            return new JsonData().fail();
        }




    }

    //  查询出单个笔记
    @GetMapping("/find/{id}")
    @ApiOperation(value = "查询出单个笔记")
    @ApiImplicitParam(name = "id",value = "待办的id",dataType = "int",paramType = "path",required = true)
    public Json<Unfinish> find(@PathVariable int id)
    {
        Note note = noteService.find(id);
        if (note != null)
        {
            return new JsonData().success(note);
        }
        else {
            return new JsonData().fail();
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


            return new JsonData().success(note);
        }else{
            return new JsonData().fail(note);
        }




    }


}
