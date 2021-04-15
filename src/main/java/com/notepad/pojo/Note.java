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
    @ApiModelProperty(name = "user_id",value = "用户id")
    private int user_id;
    @ApiModelProperty(name = "note_id",value = "笔记id")
    private int note_id;
    @ApiModelProperty(name = "note_title",value = "笔记标题")
    private String note_title;
    @ApiModelProperty(name = "note_pic",value = "笔记图片")
    private String note_pic;
    @ApiModelProperty(name = "note_content",value = "笔记内容")
    private String note_content;
    @ApiModelProperty(name = "note_date",value = "笔记更新时间")
    private Date note_date;
    @ApiModelProperty(name = "note_class_id",value = "笔记分类id")
    private int note_class_id;
    //优先级
    @ApiModelProperty(name = "top_time",value = "置顶时间")
    private Date top_time;
    @ApiModelProperty(name = "note_collect",value = "笔记是否收藏")
    private int note_collect;
    @ApiModelProperty(name = "delete_time",value = "删除时间")
    private Date delete_time;
}
