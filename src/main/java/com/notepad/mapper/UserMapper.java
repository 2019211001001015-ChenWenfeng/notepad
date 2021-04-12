package com.notepad.mapper;

import com.notepad.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
    void add(User user);
    void delete(int user_id);
    void update(User user);
    User find(int user_id);
    User login(@Param("username") String username, @Param("password") String password);
}
