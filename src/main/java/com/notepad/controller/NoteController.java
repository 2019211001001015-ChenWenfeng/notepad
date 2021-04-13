package com.notepad.controller;


import com.notepad.pojo.Note;
import com.notepad.service.NoteService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @ApiOperation("置顶功能的设置")
    @PostMapping("/setTop/{note_id}")
    @ApiImplicitParam(name = "note_id",value = "笔记序号",dataType = "int",paramType = "path",required = true)
    public String setTop(@PathVariable int note_id,Model model){
        Object user_id = model.getAttribute("user_id");
        System.out.println(note_id);
        Note note = noteService.find(note_id);
        if (note.getNote_rank()!= 0){
            note.setNote_rank(0);
            note.setTop(null);
        }else {
            note.setNote_rank(1);
            note.setTop(new Date());
        }
        noteService.update(note);
        List<Note> noteList = noteService.findAll();
        System.out.println("是否置顶"+note.getNote_rank()+"置顶时间"+note.getTop());
        return noteList.toString();//到时候在修改
    }


    @ApiOperation("删除功能")
    @PostMapping("/delete/{note_id}")
    @ApiImplicitParam(name = "note_id",value = "笔记序号",dataType = "int",paramType = "path",required = true)
    public String delete(@PathVariable int note_id){
        System.out.println(note_id);
        Note note = noteService.find(note_id);
        if (note.getNote_rank()!= 0){
            note.setNote_rank(0);
            note.setTop(null);
        }else {
            note.setNote_rank(1);
            note.setTop(new Date());
        }
        noteService.update(note);
        List<Note> noteList = noteService.findAll();
        System.out.println("是否置顶"+note.getNote_rank()+"置顶时间"+note.getTop());
        return noteList.toString();//到时候在修改
    }


//    @ApiOperation("查询所有")
//    @GetMapping("/text")
////    @ApiImplicitParam
//    public String text(){
////        Note note = new Note(3,"你是谁",null,"akdsjhdkahd",new Date(),1,1,0,null);
//        noteService.delete(3);
//        return noteService.findAll().toString();
//    }


}
