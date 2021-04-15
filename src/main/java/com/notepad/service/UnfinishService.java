package com.notepad.service;

import com.notepad.pojo.Note;
import com.notepad.pojo.Unfinish;

import java.util.List;

public interface UnfinishService {
    //查询出所有待办
    List<Unfinish> findAll();



    void add(Unfinish unfinish);
    void delete(int unfinish_id);
    void update(Unfinish unfinish);
    void update_id(int id,int unfinish_class_id);
    Unfinish find(int unfinish_id);
}
