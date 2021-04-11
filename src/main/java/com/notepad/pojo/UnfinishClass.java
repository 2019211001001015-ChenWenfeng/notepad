package com.notepad.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("待办分类")
public class UnfinishClass {

    public UnfinishClass(String unfinish_class) {
        this.unfinish_class = unfinish_class;
    }

    @ApiModelProperty("待办分类id")
    private int unfinish_class_id;

    @ApiModelProperty("待办分类名称")
    private String unfinish_class;
}
