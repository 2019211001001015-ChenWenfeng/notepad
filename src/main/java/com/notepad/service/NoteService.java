package com.notepad.service;

import com.notepad.pojo.Note;

import java.util.List;

public interface NoteService {
    List<Note> findAll(String user_id);
    List<Note> findAllByAll();
    void add(Note note);
    void delete(int note_id);
    void update(Note note);
    Note find(int note_id);
}
