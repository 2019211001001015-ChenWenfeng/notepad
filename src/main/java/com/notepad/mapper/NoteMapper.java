package com.notepad.mapper;

import com.notepad.pojo.Note;

import java.util.List;

public interface NoteMapper {
    List<Note> findAll();
    void add(Note note);
    void delete(int note_id);
    void update(Note note);
    Note find(int note_id);
}
