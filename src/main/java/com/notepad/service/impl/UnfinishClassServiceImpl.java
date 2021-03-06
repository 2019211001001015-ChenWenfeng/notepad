package com.notepad.service.impl;

import com.notepad.mapper.UnfinishClassMapper;
import com.notepad.pojo.UnfinishClass;
import com.notepad.service.UnfinishClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UnfinishClassServiceImpl implements UnfinishClassService {

    @Autowired
    private UnfinishClassMapper unfinishClassMapper;

    @Override
    public List<Map<String,Object>> findAll(int user_id) {

        return unfinishClassMapper.findAll(user_id);
    }

    @Override
    public void add(int user_id,String unfininsh_class_name) {
        unfinishClassMapper.add(user_id,unfininsh_class_name);

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
    public UnfinishClass find_id(int unfinish_class_id) {

        return unfinishClassMapper.find_id(unfinish_class_id);
    }

    @Override
    public UnfinishClass find_class(String unfinish_class_name) {
        return unfinishClassMapper.find_class(unfinish_class_name);
    }

//    @Override
//    public List<Map<String,Object>> find_name(String user_id) {
//        return unfinishClassMapper.find_name(user_id);
//    }
}
