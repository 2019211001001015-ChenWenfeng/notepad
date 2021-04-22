package com.notepad.utils;

import com.notepad.mapper.NoteMapper;
import com.notepad.mapper.UnfinishMapper;
import com.notepad.pojo.Note;
import com.notepad.pojo.Unfinish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private NoteMapper noteMapper;
    @Autowired
    private UnfinishMapper unfinishMapper;

    private SimpleDateFormat formatter =   new SimpleDateFormat( "yyyy-MM-dd");
//    private String cron = "0 0 24 * * ?";
    //在一个特定的时间执行这个方法
    //cron表达式
    // 秒 分 时 日 月 周几~
//    @Scheduled(cron = "0 0 24 * * ?")



//    @Scheduled(cron = "0/5 * * * * ?")

//    @Scheduled(cron = "0 0 0 * * ?") 每天晚上0点定时删除数据库中过期的文件
    public void deleteRecover(){

        System.out.println("程序执行中=========");
        long timeDay = 0l;
        Date date = new Date();
        long dateTime = date.getTime();
        List<Note> noteList = noteMapper.findAllByAll();
        List<Unfinish> unfinishList = unfinishMapper.findAllByAll();
        for (Note note : noteList) {
            long time = note.getDelete_time().getTime();
            timeDay = (dateTime-time)/(1000*60*60*24);
            if (timeDay >30){
//                noteMapper.delete(note.getNote_id());
                System.out.println("note ok!!");
            }
        }
        for (Unfinish unfinish : unfinishList) {
            long time1 = unfinish.getDelete_time().getTime();
            timeDay = (dateTime-time1)/(1000*60*60*24);
            if (timeDay >30){
//                unfinishMapper.delete(unfinish.getUnfinish_id());
                System.out.println("unfinish  ok!!!!");
            }
        }
    }

}
