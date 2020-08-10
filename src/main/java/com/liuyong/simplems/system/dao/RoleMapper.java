package com.liuyong.simplems.system.dao;

import com.liuyong.simplems.common.base.BaseMapper;
import com.liuyong.simplems.system.ent.Role;
import com.liuyong.simplems.system.ent.RoleMenu;
import com.liuyong.simplems.system.vo.RoleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 根据角色名集合获取角色id集合
     *
     * @param roleNameList 角色名集合
     * @return 角色id集合
     */
    List<Integer> getIdByNameBatch(List<String> roleNameList);

    /**
     * 根据用户账号获取用户的角色信息
     *
     * @param account 用户账号
     * @return 对应用户的角色集合
     */
    List<Role> getRolesByAccount(String account);

    /**
     * 列出所有角色菜单关联信息（RoleVO）
     *
     * @param
     * @return
     */
    List<RoleVO> listRoleMenus();

    /**
     * 根据角色id获取角色菜单关联信息（RoleVO）
     *
     * @param roleId 角色id
     * @return
     */
    RoleVO getRoleMenuById(int roleId);

    /**
     * 根据角色id获取角色权限关联信息（RoleVO）
     *
     * @param
     * @return
     */
    List<RoleVO> listRolePermissions();

    /**
     * 根据角色id获取角色权限关联信息（RoleVO）
     *
     * @param roleId 角色id
     * @return
     */
    RoleVO getRolePermissionById(int roleId);
}
