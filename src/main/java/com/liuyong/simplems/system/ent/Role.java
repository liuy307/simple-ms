package com.liuyong.simplems.system.ent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("角色对象")
public class Role implements Serializable {
    @ApiModelProperty(value = "主键id", example = "1")
    private Integer id;

    @ApiModelProperty("角色名")
    String roleName;

    @ApiModelProperty("描述")
    String description;

    @ApiModelProperty("角色分配菜单集合")
    List<Menu> MenuList;

    @ApiModelProperty("角色分配菜单名字集合")
    List<String> MenuNameList;
}
