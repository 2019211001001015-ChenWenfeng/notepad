package com.notepad.service.impl;

import com.notepad.mapper.NoteClassMapper;
import com.notepad.pojo.NoteClass;
import com.notepad.service.NoteClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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
    public void add(String note_class_name) {
        noteClassMapper.add(note_class_name);
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

    @Override
    public NoteClass find_class(String note_class_name) {
        return noteClassMapper.find_class(note_class_name);
    }


    @Override
    public List<Map<String, Object>> find_name() {
       return noteClassMapper.find_name();
    }
}
