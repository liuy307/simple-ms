package com.liuyong.simplems.system.ent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("用户登录信息")
public class UserInfo implements Serializable {
    @ApiModelProperty("用户")
    private User user;

    @ApiModelProperty("token")
    private String token;
//
}
