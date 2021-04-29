package com.notepad.mapper;

import com.notepad.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    List<User> findAll();
    Boolean add(User user);
    void delete(int user_id);
    void update(User user);
    User find(int user_id);
//    通过openid查询用户
    User find_openId(@Param("openId") String openId);
}
