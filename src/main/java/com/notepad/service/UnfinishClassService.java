package com.notepad.service;


import com.notepad.pojo.UnfinishClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UnfinishClassService {

    List<Map<String,Object>> findAll(int user_id);
    void add(int user_id,String unfinish_class_name);
    void delete(int unfininsh_class_id);
    void update(UnfinishClass unfinishClass);

//     通过查询id，查询待办分类
    UnfinishClass find_id(int unfinish_class_id);

    //    通过查询单板分类名称，查询待办分类
    UnfinishClass find_class(String unfinish_class_name);


//    //  查询出所有分类名称
//    List<Map<String,Object>> find_name(String user_id);
}
