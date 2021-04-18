package com.notepad.service;

import com.notepad.pojo.Note;
import com.notepad.pojo.Unfinish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnfinishService {

    //查询出所有待办
    List<Unfinish> findAll(String user_id);



    void add(Unfinish unfinish);
    void delete(@Param("unfinish_id")int unfinish_id);
    void update(Unfinish unfinish);

    //完成功能
    void complete(@Param("unfinish_id")int unfinish_id);

    //置顶功能
    void unfinishSetTop(@Param("unfinish_id")int unfinish_id);
    //删除进回收站
    void deleteToRecover(@Param("unfinish_id")int unfinish_id);
    //搜索功能
    List<Unfinish> search(@Param("user_id") String user_id,@Param("thing") String thing);

    //    待办进行分类，更改待办的unfinish_class_id
    void update_id(int id,int unfinish_class_id);

    Unfinish find(int unfinish_id);
}
