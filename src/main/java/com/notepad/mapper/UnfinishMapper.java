package com.notepad.mapper;

import com.notepad.pojo.Note;
import com.notepad.pojo.Unfinish;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UnfinishMapper {
    //通过用户查询用户所有待办
    List<Unfinish> findAll(String user_id);
    //查出全部的待办信息
    List<Unfinish> findAllByAll();

    //
    List<Unfinish> findAllByThing(@Param("user_id") String user_id,@Param("thing") String thing);


    void add(Unfinish unfinish);
    void delete(int unfinish_id);


    void update(Unfinish unfinish);

//    修改待办发收藏是0还是1
    void update_collect(@Param("unfinish_id") int unfinish_id,@Param("collect") int collect);
    
//    待办进行分类，更改待办的unfinish_class_id
    void update_id(@Param("id") int id,@Param("unfinish_class_id") int unfinish_class_id);


    Unfinish find(int unfinish_id);

//    查询出待办的收藏是0还是1
    int find_collect(int unfinish_id);


}
