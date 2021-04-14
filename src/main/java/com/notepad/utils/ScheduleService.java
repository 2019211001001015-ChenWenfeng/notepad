package com.notepad.utils;

import com.notepad.pojo.Note;
import com.notepad.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private NoteService noteService;
//    private String cron = "0 0 24 * * ?";
    //在一个特定的时间执行这个方法
    //cron表达式
    // 秒 分 时 日 月 周几~
//    @Scheduled(cron = "0 0 24 * * ?")

    public void delete(){
        Date date = new Date();
        List<Note> noteList = noteService.findAllByAll();
//        for (Note note : noteList) {
//            System.out.println(date.getTime()-note.getDelete_time().getTime());
//        }
    }
}
