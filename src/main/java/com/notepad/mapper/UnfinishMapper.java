package com.notepad.mapper;

import com.notepad.pojo.Note;
import com.notepad.pojo.Unfinish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnfinishMapper {

    List<Unfinish> findAll();
    void add(Unfinish unfinish);
    void delete(int unfinish_id);
    void update(Unfinish unfinish);
    Unfinish find(int unfinish_id);
}
