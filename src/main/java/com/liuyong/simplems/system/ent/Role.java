package com.liuyong.simplems.system.ent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("角色对象")
public class Role implements Serializable {
    @ApiModelProperty(value = "主键id", example = "1")
    private Integer id;

    @ApiModelProperty("角色名")
    String roleName;

    @ApiModelProperty("描述")
    String description;
}
