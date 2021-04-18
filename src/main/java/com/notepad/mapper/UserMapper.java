package com.notepad.mapper;

import com.notepad.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
    void add(User user);
    void delete(String user_id);
    void update(User user);
    User find(String user_id);
}
