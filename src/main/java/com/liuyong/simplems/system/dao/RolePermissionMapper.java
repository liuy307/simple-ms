package com.liuyong.simplems.system.dao;

import com.liuyong.simplems.system.ent.RoleMenu;
import com.liuyong.simplems.system.ent.RolePermission;

import java.util.List;

public interface RolePermissionMapper {
    int saveBatch(List<RolePermission> rolePermissionList);

    int removeByRoleId(int roleId);
}
