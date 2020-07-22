package com.liuyong.simplems.system.ent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户对象")
public class User {
    @ApiModelProperty(value = "主键id", example = "1")
    private Integer id;

    @ApiModelProperty("用户名")
    String userName;

    @ApiModelProperty("描述")
    String description;

    @ApiModelProperty("账号")
    String accountNumber;

    @ApiModelProperty("密码")
    String password;
}
