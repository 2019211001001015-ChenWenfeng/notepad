package com.notepad.mapper;

import com.notepad.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
    Boolean add(User user);
    void delete(int user_id);
    void update(User user);
    User find(int user_id);
//    通过openid查询用户
    User find_openId(@Param("openId") String openId);
}
