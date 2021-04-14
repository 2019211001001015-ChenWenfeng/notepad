package com.notepad.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("笔记")//swagger实体类注解
public class Note {
    @ApiModelProperty(name = "note_id",value = "笔记id")
    private int note_id;
    @ApiModelProperty(name = "note_title")
    private String note_title;
    @ApiModelProperty(name = "note_pic")
    private String note_pic;
    @ApiModelProperty(name = "note_content")
    private String note_content;
    @ApiModelProperty(name = "note_date")
    private Date note_date;
    @ApiModelProperty(name = "note_class_id")
    private int note_class_id;
    //优先级
    @ApiModelProperty(name = "top_time")
    private Date top_time;
    @ApiModelProperty(name = "note_collect")
    private int note_collect;
    @ApiModelProperty(name = "delete_time")
    private Date delete_time;
}
