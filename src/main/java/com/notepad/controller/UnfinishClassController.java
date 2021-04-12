package com.notepad.controller;

import com.notepad.pojo.UnfinishClass;
import com.notepad.service.UnfinishClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/unfinishClass")
public class UnfinishClassController {

    @Autowired
    private UnfinishClassService unfinishClassService;

//    新增待办分类
    @GetMapping("/addCla")
    public UnfinishClass addCla()
    {
        String s = "";
        UnfinishClass unfinCla = new UnfinishClass(s);
        unfinishClassService.add(unfinCla);
        return unfinCla;
    }

//    查询出待办分类信息
    @GetMapping("/findAllCla")

    public List<UnfinishClass> findAllCla()
    {
        List<UnfinishClass> unfinishClasses = unfinishClassService.findAll();
        return unfinishClasses;
    }




}
