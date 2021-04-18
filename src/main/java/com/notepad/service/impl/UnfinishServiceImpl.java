package com.notepad.service.impl;

import com.notepad.mapper.UnfinishMapper;
import com.notepad.pojo.Note;
import com.notepad.pojo.Unfinish;
import com.notepad.service.UnfinishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional  // 根据你的配置，设置是否自动开启事务
                //自动提交事务或者遇到异常自动回滚
public class UnfinishServiceImpl implements UnfinishService {

    @Autowired
    private UnfinishMapper unfinishMapper;
    @Override
    public List<Unfinish> findAll(String user_id) {


        return  unfinishMapper.findAll(user_id);
    }



    @Override
    public void add(Unfinish unfinish) {

        unfinishMapper.add(unfinish);

    }

    @Override
    public void delete(int unfinish_id) {
        unfinishMapper.delete(unfinish_id);
    }

    @Override
    public void update(Unfinish unfinish) {
        unfinishMapper.update(unfinish);
    }

    //完成功能
    @Override
    public void complete(int unfinish_id) {
//        System.out.println(unfinish_id);
//        Object user = model.getAttribute("user");
//        System.out.println(user);
        //找出要修改笔记信息
        Unfinish unfinish = unfinishMapper.find(unfinish_id);
        //判断笔记是否完成
        if (unfinish.getComplete() > 0){
            //如果置顶就取消完成
            unfinish.setComplete(0);
        }else {
            //如果没有就加入完成
            unfinish.setComplete(1);
        }
        //修改笔记
        unfinishMapper.update(unfinish);
        //便于查看是否修改成功
//        List<Unfinish> unfinishList = unfinishMapper.findAll("1010");
//        System.out.println("置顶时间"+unfinish.getComplete());
//        return unfinishList.toString();//到时候在修改
    }


    //待办置顶功能
    @Override
    public void unfinishSetTop(int unfinish_id) {
//        System.out.println(unfinish_id);
//        Object user = model.getAttribute("user");
//        System.out.println(user);
        //找出要置顶笔记信息
        Unfinish unfinish = unfinishMapper.find(unfinish_id);
        //判断笔记是否置顶
        if (unfinish.getTop_time()!=null){
            //如果置顶就取消置顶
            unfinish.setTop_time(null);
        }else {
            //如果没有就加入置顶时间
            unfinish.setTop_time(new Date());
        }
        //修改笔记
        unfinishMapper.update(unfinish);
        //便于查看是否修改成功
//        List<Unfinish> unfinishList = unfinishMapper.findAll("1010");
//        System.out.println("置顶时间"+unfinish.getTop_time());
//        return unfinishList.toString();//到时候在修改
    }

    //删除进回收站功能
    @Override
    public void deleteToRecover(int unfinish_id) {
//        System.out.println(unfinish_id);
        Unfinish unfinish = unfinishMapper.find(unfinish_id);
        if (unfinish.getDelete_time()!=null){
            unfinish.setDelete_time(null);
        }else {
            unfinish.setDelete_time(new Date());
        }
        unfinishMapper.update(unfinish);
//        List<Unfinish> unfinishList = unfinishMapper.findAll("1010");
//        System.out.println("删除时间"+unfinish.getDelete_time());
//        return unfinishList.toString();//到时候在修改
    }

    @Override
    public List<Unfinish> search(String user_id, String thing) {
        return unfinishMapper.findAllByThing(user_id, thing);
    }


    @Override
    public void update_id(int id,int unfinish_class_id) {
        unfinishMapper.update_id(id,unfinish_class_id);
    }

    @Override
    public Unfinish find(int unfinish_id) {

        return unfinishMapper.find(unfinish_id);
    }
}
