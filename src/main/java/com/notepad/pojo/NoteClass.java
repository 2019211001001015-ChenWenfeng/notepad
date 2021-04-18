package com.notepad.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("笔记分类")
public class NoteClass {//属性值为private不能加swagger属性注解


    public NoteClass(String note_class_name) {
        this.note_class_name = note_class_name;
    }

    @ApiModelProperty("用户的id")
    private int user_id;

    @ApiModelProperty(value = "笔记分类id")
    private int note_class_id;
    @ApiModelProperty(value = "笔记分类名称")
    private String note_class_name;

}
