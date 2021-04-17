package com.notepad.service.impl;

import com.notepad.mapper.NoteMapper;
import com.notepad.pojo.Note;
import com.notepad.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteMapper noteMapper;
    @Override
    //通过用户名查询所有笔记
    public List<Note> findAll(String user_id) {
        return noteMapper.findAll(user_id);
    }

    //通过笔记id查询笔记
    @Override
    public Note find(int note_id) {
        return noteMapper.find(note_id);
    }
    //查询数据库中的所有笔记
    @Override
    public List<Note> findAllByAll() {
        return noteMapper.findAllByAll();
    }

    //新增笔记功能
    @Override
    public void add(Note note) {
        noteMapper.add(note);
    }

    //删除笔记功能
    @Override
    public void delete(int note_id) {
        noteMapper.delete(note_id);
    }

    //修改笔记功能
    @Override
    public void update(Note note) {
        noteMapper.update(note);
    }

    //笔记置顶功能
    @Override
    public void noteSetTop(int note_id) {
//        System.out.println(note_id);
//        Object user = model.getAttribute("user");
//        System.out.println(user);
        //找出要置顶笔记信息
        Note note = noteMapper.find(note_id);
        //判断笔记是否置顶
        if (note.getTop_time()!=null){
            //如果置顶就取消置顶
            note.setTop_time(null);
        }else {
            //如果没有就加入置顶时间
            note.setTop_time(new Date());
        }
        //修改笔记
        noteMapper.update(note);
        //便于查看是否修改成功
//        List<Note> noteList = noteService.findAll("1010");
//        System.out.println("置顶时间"+note.getTop_time());
//        return noteList.toString();//到时候在修改
    }

    //笔记删除进回收站功能
    @Override
    public void deleteToRecover(int note_id) {
//        System.out.println(note_id);
        Note note = noteMapper.find(note_id);
        if (note.getDelete_time()!=null){
            note.setDelete_time(null);
        }else {
            note.setDelete_time(new Date());
        }
        noteMapper.update(note);
//        List<Note> noteList = noteService.findAll("1010");
//        System.out.println("删除时间"+note.getDelete_time());
//        return noteList.toString();//到时候在修改
    }


    //修改笔记分类功能
    @Override
    public void update_id(int id, int note_class_id) {
        noteMapper.update_id(id,note_class_id);
    }

}
