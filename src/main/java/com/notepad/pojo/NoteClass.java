package com.notepad.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("笔记分类")
public class NoteClass {//属性值为private不能加swagger属性注解
    private int note_class_id;
    private String note_class_name;
    private int note_number;
}
