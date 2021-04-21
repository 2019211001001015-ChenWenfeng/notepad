package com.notepad.service.impl;

import com.notepad.mapper.UserMapper;
import com.notepad.pojo.User;
import com.notepad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

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
    public Boolean add(User user) {
        return userMapper.add(user);
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

    @Override
    public boolean login(User user) {
        User user1 = userMapper.find(user.getUser_id());
        if (user1 ==null){
            userMapper.add(user);
            return true;
        }else {
            if (user1.getUsername().equals(user.getUsername())&&user1.getHead_portrait().equals(user.getHead_portrait())){
                System.out.println("登录成功！！！");
                return true;
            }else {
                System.out.println("用户名密码错误！！");
                return false;
            }
        }
    }

    @Override
    public User find_openId(String openId) {
        return userMapper.find_openId(openId);
    }
}
