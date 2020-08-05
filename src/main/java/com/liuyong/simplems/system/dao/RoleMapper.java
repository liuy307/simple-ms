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

    List<Role> listRolePermissions();
    Role getRolePermissionById(int roleId);

    /**
     * 根据用户账号获取用户的角色信息
     *
     * @param account 用户账号
     * @return 对应用户的角色集合
     */
    List<Role> getRolesByAccount(String account);
}
