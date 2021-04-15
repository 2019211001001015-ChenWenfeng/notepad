package com.notepad.mapper;

import com.notepad.pojo.NoteClass;
import com.notepad.pojo.UnfinishClass;

import java.util.List;

public interface UnfinishClassMapper {

    List<UnfinishClass> findAll();
    void add(String unfininsh_class_name);
    void delete(int unfininsh_class_id);
    void update(UnfinishClass unfinishClass);

//    通过查询id，查询待办分类
    UnfinishClass find_id(int unfinish_class_id);

//    通过查询单板分类名称，查询待办分类
    UnfinishClass find_class(String unfinish_class_name);

}
