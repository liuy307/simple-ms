package com.liuyong.simplems.system.dao;

import com.liuyong.simplems.common.base.BaseMapper;
import com.liuyong.simplems.system.ent.RoleMenu;

import java.util.List;

public interface RoleMenuMapper {
    int saveBatch(List<RoleMenu> roleMenuList);

    int removeByRoleId(int roleId);
}
