package com.notepad.mapper;

import com.notepad.pojo.Note;
import com.notepad.pojo.Unfinish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnfinishMapper {
//查询出所有待办
    List<Unfinish> findAll();


    void add(Unfinish unfinish);
    void delete(int unfinish_id);
    void update(Unfinish unfinish);
    void update_id(@Param("id") int id,@Param("unfinish_class_id") int unfinish_class_id);
    Unfinish find(int unfinish_id);
}
