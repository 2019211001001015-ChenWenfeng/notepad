package com.notepad.mapper;

import com.notepad.pojo.NoteClass;
import com.notepad.pojo.UnfinishClass;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NoteClassMapper {
    List<Map<String,Object>>findAll(int user_id);

//笔记分类只有名称需要加入，不需要笔记对象
    void add(@Param("user_id") int user_id,@Param("note_class_name") String note_class_name);
    void delete(int note_class_id);
    void update(NoteClass noteClass);
    NoteClass find(int note_class_id);

    //    通过查询笔记分类名称，查询笔记分类
    NoteClass find_class(String note_class_name);

//    //  查询出所有笔记名称
//    List<Map<String,Object>> find_name(String user_id);
}
