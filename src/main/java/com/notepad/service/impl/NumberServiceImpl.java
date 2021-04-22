package com.notepad.service.impl;

import com.notepad.mapper.NoteMapper;
import com.notepad.mapper.UnfinishMapper;
import com.notepad.pojo.ClassNoteNumber;
import com.notepad.pojo.ClassUnfinishNumber;
import com.notepad.service.NumberService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class NumberServiceImpl implements NumberService {
    @Autowired
    private NoteMapper noteMapper;
    @Autowired
    private UnfinishMapper unfinishMapper;

//    @Override
//    public Map<String, Integer> findAllNumber(int user_id) {
//        List<Integer> noteNumber = noteMapper.findNoteNumber(user_id);
//        List<Integer> unfinishNumber = unfinishMapper.findUnfinishNumber(user_id);
//        Integer noteCollectNumber = noteMapper.findNoteCollectNumber(user_id);
//        Integer unfinishCollectNumber = unfinishMapper.findUnfinishCollectNumber(user_id);
//        List<ClassNoteNumber> noteClassNumber = noteMapper.findNoteClassNumber(user_id);
//        List<ClassUnfinishNumber> unfinishClassNumber = unfinishMapper.findUnfinishClassNumber(user_id);
//        Map<String, Integer> numberList = new HashMap<>();
//        numberList.put("全部笔记",noteNumber.get(0));
//        numberList.put("删除笔记",noteNumber.get(1));
//        numberList.put("全部待办",unfinishNumber.get(0));
//        numberList.put("删除待办",unfinishNumber.get(1));
//        numberList.put("收藏笔记",noteCollectNumber);
//        numberList.put("收藏待办",unfinishCollectNumber);
//        numberList.putAll((Map<? extends String, ? extends Integer>) noteClassNumber);
//        numberList.putAll((Map<? extends String, ? extends Integer>) unfinishClassNumber);
//        return numberList;
//    }

    @Override
    public Map<String, Integer> findNoteNumber(int user_id) {
        List<Integer> noteNumber = noteMapper.findNoteNumber(user_id);
        Integer noteCollectNumber = noteMapper.findNoteCollectNumber(user_id);
        Map<String, Integer> numberList = new HashMap<>();
        numberList.put("全部笔记",noteNumber.get(0));
        numberList.put("删除笔记",noteNumber.get(1));
        numberList.put("收藏笔记",noteCollectNumber);
        return numberList;
    }

    @Override
    public Map<String, Integer> findNoteClassNumber(int user_id) {
        List<ClassNoteNumber> noteClassNumber = noteMapper.findNoteClassNumber(user_id);
        Map<String, Integer> numberList = new HashMap<>();
        for (ClassNoteNumber classNoteNumber : noteClassNumber) {
            numberList.put(classNoteNumber.getNote_class_name(),classNoteNumber.getNote_number());
        }
        return numberList;
    }

    @Override
    public Map<String, Integer> findUnfinishNumber(int user_id) {
        List<Integer> unfinishNumber = unfinishMapper.findUnfinishNumber(user_id);
        Integer unfinishCollectNumber = unfinishMapper.findUnfinishCollectNumber(user_id);
        Map<String, Integer> numberList = new HashMap<>();
        numberList.put("全部待办",unfinishNumber.get(0));
        numberList.put("删除待办",unfinishNumber.get(1));
        numberList.put("收藏待办",unfinishCollectNumber);
        return numberList;
    }

    @Override
    public Map<String, Integer> findUnfinishClassNumber(int user_id) {
        List<ClassUnfinishNumber> unfinishClassNumber = unfinishMapper.findUnfinishClassNumber(user_id);
        Map<String, Integer> numberList = new HashMap<>();
        for (ClassUnfinishNumber classUnfinishNumber : unfinishClassNumber) {
            numberList.put(classUnfinishNumber.getUnfinish_class_name(),classUnfinishNumber.getUnfinish_number());
        }
        return numberList;
    }
}
