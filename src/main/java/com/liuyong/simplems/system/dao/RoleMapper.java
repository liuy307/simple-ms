package com.liuyong.simplems.system.dao;

import com.liuyong.simplems.common.base.BaseMapper;
import com.liuyong.simplems.system.ent.Role;
import com.liuyong.simplems.system.ent.RoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    List<Integer> getIdByNameBatch(List<String> roleNameList);

    List<Role> listRoleMenus();
    Role getRoleMenuById(int id);

    int saveRoleMenuBatch(List<RoleMenu> roleMenuList);

    int removeRoleMenu(int userId);
}
