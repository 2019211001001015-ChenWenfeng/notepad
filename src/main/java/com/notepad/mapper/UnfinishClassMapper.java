package com.notepad.mapper;

import com.notepad.pojo.NoteClass;
import com.notepad.pojo.UnfinishClass;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface UnfinishClassMapper {

    List<Map<String,Object>> findAll(int user_id);
    void add(@Param("user_id") int user_id,@Param("unfinish_class_name") String unfinish_class_name);
    void delete(int unfininsh_class_id);
    void update(UnfinishClass unfinishClass);

//    通过查询id，查询待办分类
    UnfinishClass find_id(int unfinish_class_id);

//    通过查询待办分类名称，查询待办分类
    UnfinishClass find_class(String unfinish_class_name);



}
