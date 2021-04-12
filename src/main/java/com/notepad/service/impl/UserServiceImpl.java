package com.notepad.service.impl;

import com.notepad.mapper.UserMapper;
import com.notepad.pojo.User;
import com.notepad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public void delete(int user_id) {
        userMapper.delete(user_id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User find(int user_id) {
        return userMapper.find(user_id);
    }
}
