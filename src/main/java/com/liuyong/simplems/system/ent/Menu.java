package com.liuyong.simplems.system.ent;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("角色对象")
public class Menu implements Serializable {
    @ApiModelProperty(value = "主键id", example = "1")
    private Integer id;

    @ApiModelProperty("菜单名")
    private String menuName;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty(value = "父菜单Id", example = "0")
    private int parentMenuId;

    @ApiModelProperty("子菜单集合")
    private List<Menu> childMenusList;
}