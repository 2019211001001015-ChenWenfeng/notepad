package com.notepad.service;

import com.notepad.pojo.Note;
import org.apache.ibatis.annotations.Param;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface NoteService {
    List<Note> findAll(int user_id);
    List<Note> findAllByAll();
    int add(Note note);
    void delete(@Param("note_id")int note_id);
    void update(Note note);

    //置顶功能
    void noteSetTop(@Param("note_id")int note_id);

    //删除进回收站
    void deleteToRecover(@Param("note_id")int note_id);

    //搜索
    List<Note> search(@Param("user_id") int user_id,@Param("thing") String thing);

    //    笔记进行分类，更改笔记的unfinish_class_id
    void update_id(@Param("id") int id, @Param("note_class_id") int note_class_id);
    Note find(int note_id);

    //    查询出待办的收藏是0还是1
    int find_collect(int note_id);


    //    修改待办发收藏是0还是1
    void update_collect( int note_id, int collect);

}
