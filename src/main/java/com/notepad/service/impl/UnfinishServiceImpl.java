package com.notepad.service.impl;

import com.notepad.mapper.UnfinishMapper;
import com.notepad.pojo.Note;
import com.notepad.pojo.Unfinish;
import com.notepad.service.UnfinishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional  // 根据你的配置，设置是否自动开启事务
                //自动提交事务或者遇到异常自动回滚
public class UnfinishServiceImpl implements UnfinishService {

    @Autowired
    private UnfinishMapper unfinishMapper;
    @Override
    public List<Unfinish> findAll() {


        return  unfinishMapper.findAll();
    }



    @Override
    public void add(Unfinish unfinish) {

        unfinishMapper.add(unfinish);

    }

    @Override
    public void delete(int unfinish_id) {
        unfinishMapper.delete(unfinish_id);

    }

    @Override
    public void update(Unfinish unfinish) {
        unfinishMapper.update(unfinish);
    }

    @Override
    public Unfinish find(int unfinish_id) {

        return unfinishMapper.find(unfinish_id);
    }
}
