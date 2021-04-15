package com.notepad.service;

import com.notepad.pojo.Note;
import com.notepad.pojo.Unfinish;

import java.util.List;

public interface UnfinishService {

    //查询出所有待办
    List<Unfinish> findAll(String user_id);



    void add(Unfinish unfinish);
    void delete(int unfinish_id);
    void update(Unfinish unfinish);

    //    待办进行分类，更改待办的unfinish_class_id
    void update_id(int id,int unfinish_class_id);

    Unfinish find(int unfinish_id);
}
