package com.notepad.controller;

import com.notepad.mapper.UnfinishMapper;
import com.notepad.pojo.Note;
import com.notepad.pojo.Unfinish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/unfinish")
public class UnfinishController {
    @Autowired
    private UnfinishMapper unfinishMapper;


    @GetMapping("/add")
    public Unfinish add()
    {

//        unfinishMapper.add(unfinish);

            Unfinish unfinish = new Unfinish(2,"明天",new Date(),2,2);
            unfinishMapper.update(unfinish);

        return unfinish;


    }

}
