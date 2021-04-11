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
        List<UnfinishClass> unfinishClasses = unfinishClassMapper.findAll();
        return unfinishClasses;
    }

    @Override
    public void add(UnfinishClass unfinishClass) {
        unfinishClassMapper.add(unfinishClass);

    }

    @Override
    public void delete(int unfininsh_class_id) {
        unfinishClassMapper.delete(unfininsh_class_id);

    }

    @Override
    public void update(UnfinishClass unfinishClass) {
        unfinishClassMapper.update(unfinishClass);
    }

    @Override
    public UnfinishClass find(int unfinish_class_id) {
        UnfinishClass unfinishClass = unfinishClassMapper.find(unfinish_class_id);
        return unfinishClass;
    }
}
