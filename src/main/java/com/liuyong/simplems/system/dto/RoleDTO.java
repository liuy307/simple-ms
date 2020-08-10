package com.liuyong.simplems.system.dto;

import com.liuyong.simplems.system.ent.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 角色DTO
 *
 * @author liuyong
 * @date 2020/8/10 16:38
 */
@Data
public class RoleDTO extends Role {
    @ApiModelProperty("角色分配菜单名字集合")
    private List<String> MenuNameList;

    @ApiModelProperty("角色分配权限名字集合")
    private List<String> PermissionNameList;
}
