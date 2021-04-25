package com.notepad.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户")
public class User {
    @ApiModelProperty(name = "user_id",value = "用户id")
    private int user_id;
    @ApiModelProperty(name = "user_open_id",value = "微信用户唯一标识的code")
    private String user_open_id;
    @ApiModelProperty(name = "username",value = "用户名")
    private String username;
    @ApiModelProperty(name = "head_portrait",value = "用户头像")
    private String head_portrait;
    @ApiModelProperty(name="user_login_time",value = "用户登录时间")
    private Date user_login_time;
}
