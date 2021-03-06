package com.notepad.service;

import com.notepad.pojo.User;
import org.springframework.ui.Model;

import java.util.List;

public interface UserService {
    List<User> findAll();
    Boolean add(User user);
    void delete(int user_id);
    void update(User user);
    User find(int user_id);
    boolean login(User user);

    //    通过openid查询用户
    User find_openId(String openId);
}
