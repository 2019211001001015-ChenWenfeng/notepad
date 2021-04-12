package com.notepad.service.impl;

import com.notepad.mapper.NoteClassMapper;
import com.notepad.pojo.NoteClass;
import com.notepad.service.NoteClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional

public class NoteClassServiceImpl implements NoteClassService {
    @Autowired
    private NoteClassMapper noteClassMapper;
    @Override
    public List<NoteClass> findAll() {
        return noteClassMapper.findAll();
    }

    @Override
    public void add(NoteClass noteClass) {
        noteClassMapper.add(noteClass);
    }

    @Override
    public void delete(int note_class_id) {
        noteClassMapper.delete(note_class_id);
    }

    @Override
    public void update(NoteClass noteClass) {
        noteClassMapper.update(noteClass);
    }

    @Override
    public NoteClass find(int note_class_id) {
        return noteClassMapper.find(note_class_id);
    }
}
