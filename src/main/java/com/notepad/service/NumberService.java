package com.notepad.service;



import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface NumberService {
    Map<String,Integer> findNoteNumber(@Param("user_id") int user_id);
    Map<String,Integer> findNoteClassNumber(@Param("user_id") int user_id);
    Map<String,Integer> findUnfinishNumber(@Param("user_id") int user_id);
    Map<String,Integer> findUnfinishClassNumber(@Param("user_id") int user_id);
}
