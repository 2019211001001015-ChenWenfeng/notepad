package com.notepad.service;

import com.notepad.pojo.User;
import org.springframework.ui.Model;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void add(User user);
    void delete(String user_id);
    void update(User user);
    User find(String user_id);
    boolean login(User user);
}
