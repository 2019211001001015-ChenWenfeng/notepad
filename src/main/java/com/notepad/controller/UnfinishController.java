package com.notepad.controller;

import com.notepad.mapper.UnfinishMapper;
import com.notepad.pojo.Note;
import com.notepad.pojo.Unfinish;
import com.notepad.service.UnfinishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/unfinish")
public class UnfinishController {
    @Autowired
    private UnfinishService unfinishService;

//  添加待办
    @GetMapping("/add")
    public Unfinish add()
    {
        int complete = 0;
        Unfinish unfinish = new Unfinish("想大吃一顿",new Date(),1,3,complete);
        unfinishService.add(unfinish);
        System.out.println("jj");
        return unfinish;

    }

//    查询出所有的待办
    @GetMapping("/findAll")
    public List<Unfinish> findAll()
    {
        List<Unfinish> unfinishList = unfinishService.findAll();



        return unfinishList;
    }
//  查询出单个待办
    @GetMapping("/find")
    public Unfinish find(int id, Model model)
    {
        Unfinish unfinish = unfinishService.find(id);
        model.addAttribute("unfinish",unfinish);
        return unfinish;

    }
//    给待办进行分类
//    @GetMapping("/classify")
//    public Unfinish classify()
//    {
//        String s = "";
//
//
//    }

}
