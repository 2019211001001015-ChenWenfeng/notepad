package com.notepad.service;

import com.notepad.pojo.Note;
import com.notepad.pojo.Unfinish;

import java.util.List;

public interface UnfinishService {

    List<Unfinish> findAll();
    void add(Unfinish unfinish);
    void delete(int unfinish_id);
    void update(Unfinish unfinish);
    Unfinish find(int unfinish_id);
}
