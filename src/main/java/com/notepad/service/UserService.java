package com.notepad.service;

import com.notepad.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void add(User user);
    void delete(int user_id);
    void update(User user);
    User find(int user_id);
}
