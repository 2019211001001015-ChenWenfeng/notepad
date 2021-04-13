package com.notepad.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("待办") //增加中文注释
public class Unfinish {


    public Unfinish(int unfinish_id, String unfinish_content, Date unfinish_date, int unfinish_class_id, int unfinish_collect, int complete, Date top_time) {
        this.unfinish_id = unfinish_id;
        this.unfinish_content = unfinish_content;
        this.unfinish_date = unfinish_date;
        this.unfinish_class_id = unfinish_class_id;
        this.unfinish_collect = unfinish_collect;
        this.complete = complete;
        this.top_time = top_time;
    }

    @ApiModelProperty("用户id")//给字段增加中文注释
    private String user_id;

    @ApiModelProperty("待办id")//给字段增加中文注释
    private int unfinish_id;

    @ApiModelProperty("待办内容")
    private String unfinish_content;

    @ApiModelProperty("待办创建时间")
//    @JsonFormat()
    private Date unfinish_date;

    @ApiModelProperty("待办分类的id")
    private int unfinish_class_id;

    @ApiModelProperty("待办数量")
    private int unfinish_collect;

    @ApiModelProperty("待办是否完成")
    private int complete;

    @ApiModelProperty("置顶时间")
    private Date top_time;

}
