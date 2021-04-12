package com.notepad.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("笔记")//swagger实体类注解
public class Note {
    private int note_id;
    private String note_title;
    private String note_pic;
    private String note_content;
    private Date note_date;
    private int note_class_id;
    //优先级
    private int note_rank;
    private int note_collect;
    private Date delete_time;
}
