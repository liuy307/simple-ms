package com.liuyong.simplems.system.ent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@ApiModel("用户登录信息")
public class UserInfo implements Serializable {
    @ApiModelProperty("用户")
    private User user;

    @ApiModelProperty("token")
    private String token;

    @ApiModelProperty("roleNameSet")
    private Set<String> roleNameSet;

    @ApiModelProperty("menuNameSet")
    private Set<String> menuNameSet;
    
    @ApiModelProperty("permissionNameSet")
    private Set<String> permissionNameSet;
}
