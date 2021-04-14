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


    @ApiOperation("查询所有")
    @GetMapping("/text")
    @ApiImplicitParam
    public String text(){
//        Note note = new Note(3,"你是谁",null,"akdsjhdkahd",new Date(),1,1,0,null);
//        noteService.delete(3);
        return noteService.findAllByAll().toString();
    }


}
