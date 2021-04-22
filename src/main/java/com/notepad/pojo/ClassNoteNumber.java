package com.notepad.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("分类笔记数量")//swagger实体类注解
public class ClassNoteNumber {
    @ApiModelProperty(value = "笔记分类名称")
    private String note_class_name;
    @ApiModelProperty(value = "分类笔记数量")
    private int note_number;
}
