package com.notepad.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("分类待办数量")//swagger实体类注解
public class ClassUnfinishNumber {
    @ApiModelProperty(value = "待办分类名称")
    private String unfinish_class_name;
    @ApiModelProperty(value = "分类待办数量")
    private int unfinish_number;
}
