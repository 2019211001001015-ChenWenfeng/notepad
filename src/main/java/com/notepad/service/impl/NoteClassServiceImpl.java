package com.notepad.service.impl;

import com.notepad.pojo.NoteClass;
import com.notepad.service.NoteClassService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional

public class NoteClassServiceImpl implements NoteClassService {
    @Override
    public List<NoteClass> findAll() {
        return null;
    }

    @Override
    public void add(NoteClass noteClass) {

    }

    @Override
    public void delete(int note_class_id) {

    }

    @Override
    public void update(NoteClass noteClass) {

    }

    @Override
    public NoteClass find(int note_class_id) {
        return null;
    }
}
