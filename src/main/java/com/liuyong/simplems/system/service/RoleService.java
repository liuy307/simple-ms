package com.liuyong.simplems.system.service;

import com.liuyong.simplems.common.base.BaseService;
import com.liuyong.simplems.system.ent.Role;

import java.util.List;

public interface RoleService extends BaseService<Role> {
    List<Role> listRoleMenus();
    Role getRoleMenuById(int roleId);

    int saveRoleAndRoleMenu(Role role);

    int removeRoleAndRoleMenu(int roleId);

    int updateRoleAndRoleMenu(Role role);

    List<Role> listRolePermissions();
    Role getRolePermissionById(int roleId);

    int saveRoleAndRolePermission(Role role);

    int removeRoleAndRolePermission(int roleId);

    int updateRoleAndRolePermission(Role role);
}
