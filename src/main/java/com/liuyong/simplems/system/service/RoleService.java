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
}
