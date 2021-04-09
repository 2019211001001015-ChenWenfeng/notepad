package com.notepad.mapper;

import com.notepad.pojo.NoteClass;

import java.util.List;

public interface NoteClassMapper {
    List<NoteClass> findAll();
    void add(NoteClass noteClass);
    void delete(int note_class_id);
    void update(NoteClass noteClass);
    NoteClass find(int note_class_id);
}
