package com.notepad.service.impl;

import com.notepad.mapper.NoteMapper;
import com.notepad.pojo.Note;
import com.notepad.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteMapper noteMapper;
    @Override
    public List<Note> findAll() {

        return noteMapper.findAll();
    }

    @Override
    public void add(Note note) {
        noteMapper.add(note);
    }

    @Override
    public void delete(int note_id) {
        noteMapper.delete(note_id);
    }

    @Override
    public void update(Note note) {
        noteMapper.update(note);
    }

    @Override
    public Note find(int note_id) {
        return noteMapper.find(note_id);
    }
}
