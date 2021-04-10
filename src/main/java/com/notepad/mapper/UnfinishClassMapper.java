package com.notepad.mapper;

import com.notepad.pojo.NoteClass;
import com.notepad.pojo.UnfinishClass;

import java.util.List;

public interface UnfinishClassMapper {

    List<UnfinishClass> findAll();
    void add(UnfinishClass unfinishClass);
    void delete(int unfininsh_class_id);
    void update(UnfinishClass unfinishClass);
    UnfinishClass find(int unfinish_class_id);
}
