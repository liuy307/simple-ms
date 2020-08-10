package com.liuyong.simplems.system.vo;

import com.liuyong.simplems.system.ent.Menu;
import com.liuyong.simplems.system.ent.Permission;
import com.liuyong.simplems.system.ent.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 角色VO类
 *
 * @author liuyong
 * @date 2020/8/10 15:13
 */
@Data
public class RoleVO extends Role {
    @ApiModelProperty("角色分配菜单集合")
    private List<Menu> MenuList;

    @ApiModelProperty("角色分配权限集合")
    private List<Permission> PermissionList;
}
