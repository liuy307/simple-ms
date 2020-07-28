package com.liuyong.simplems.system.ent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("用户对象")
public class User implements Serializable {
    @ApiModelProperty(value = "主键id", example = "1")
    private Integer id;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("账号")
    private String accountNumber;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("用户角色集合")
    private List<Role> roleList;

    @ApiModelProperty("用户分配角色名字集合")
    private List<String> roleNameList;
}
