package com.liuyong.simplems.system.ent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("权限对象")
public class Permission implements Serializable {
    @ApiModelProperty(value = "主键id", example = "1")
    private Integer id;

    @ApiModelProperty("权限名")
    private String PermissionName;

    @ApiModelProperty("描述")
    private String description;
}