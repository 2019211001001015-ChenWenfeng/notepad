package com.notepad.controller;


import com.notepad.pojo.Note;
import com.notepad.service.NoteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;
    //设置优先级
    static int rank = 0;

    @ApiOperation("置顶功能的设置")
    @PostMapping("/setTop/{user_id}")
    public String setTop(@PathVariable @ApiParam("笔记序号") Integer user_id){
        Note note = noteService.find(user_id);
        note.setNote_rank(rank);
        rank = rank + 1;
        noteService.update(note);
        List<Note> noteList = noteService.findAll();
        System.out.println(rank);
        return noteList.toString();//到时候在修改
    }


}
