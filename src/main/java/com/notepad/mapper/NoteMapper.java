package com.notepad.mapper;

import com.notepad.pojo.ClassNoteNumber;
import com.notepad.pojo.Note;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoteMapper {
    List<Note> findAll(int user_id);

    List<Note> findAllByAll();

    int add(Note note);

    void delete(int note_id);

    void update(Note note);
    List<Note> findAllByThing(@Param("user_id") int user_id,@Param("thing") String thing);
    //    笔记进行分类，更改笔记的unfinish_class_id
    void update_id(@Param("id") int id, @Param("note_class_id") int note_class_id);
    Note find(int note_id);
    //    查询出待办的收藏是0还是1
    int find_collect(int note_id);
    //    修改待办发收藏是0还是1
    void update_collect(@Param("note_id") int note_id,@Param("collect") int collect);

    //查询删除和未删除的笔记数量
    List<Integer> findNoteNumber(@Param("user_id") int user_id);

    //查询分类笔记数量
    List<ClassNoteNumber> findNoteClassNumber(@Param("user_id") int user_id);

    //收藏的笔记数量
    Integer findNoteCollectNumber(@Param("user_id") int user_id);
}
