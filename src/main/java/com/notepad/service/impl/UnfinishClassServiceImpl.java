package com.notepad.service.impl;

import com.notepad.mapper.UnfinishClassMapper;
import com.notepad.pojo.UnfinishClass;
import com.notepad.service.UnfinishClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UnfinishClassServiceImpl implements UnfinishClassService {

    @Autowired
    private UnfinishClassMapper unfinishClassMapper;

    @Override
    public List<UnfinishClass> findAll() {
        return null;
    }

    @Override
    public void add(UnfinishClass unfinishClass) {

    }

    @Override
    public void delete(int unfininsh_class_id) {

    }

    @Override
    public void update(UnfinishClass unfinishClass) {

    }

    @Override
    public UnfinishClass find(int unfinish_class_id) {
        return null;
    }
}
