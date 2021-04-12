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
    Unfinish find(int unfinish_id);
}
