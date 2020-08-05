package com.liuyong.simplems.system.service;

import com.liuyong.simplems.common.base.BaseService;
import com.liuyong.simplems.system.ent.Role;

import java.util.List;
/**
 * 角色Service接口
 *
 * @author liuyong
 * @date 2020/8/5 10:17
 */
public interface RoleService extends BaseService<Role> {
    /**
     * 查看角色菜单联合查询结果
     *
     * @param
     * @return
     */
    List<Role> listRoleMenus();

    /**
     * 查看角色菜单联合查询结果（通过角色id）
     *
     * @param roleId 角色id
     * @return
     */
    Role getRoleMenuById(int roleId);

    /**
     * 创建角色表和角色菜单中间表记录
     *
     * @param role
     * @return 受影响记录条数
     */
    int saveRoleAndRoleMenu(Role role);

    /**
     * 删除角色表和角色菜单中间表记录
     *
     * @param roleId 角色id
     * @return 受影响记录条数
     */
    int removeRoleAndRoleMenu(int roleId);

    /**
     * 修改角色表和角色菜单中间表记录
     *
     * @param role 角色信息
     * @return 受影响记录条数
     */
    int updateRoleAndRoleMenu(Role role);

    /**
     * 查看角色权限联合查询结果
     *
     * @param
     * @return
     */
    List<Role> listRolePermissions();

    /**
     * 查看角色权限联合查询结果（通过角色id）
     *
     * @param roleId 角色id
     * @return
     */
    Role getRolePermissionById(int roleId);

    /**
     * 创建角色表和角色权限中间表记录
     *
     * @param role 角色信息
     * @return 受影响记录条数
     */
    int saveRoleAndRolePermission(Role role);

    /**
     * 删除角色表和角色权限中间表记录
     *
     * @param roleId 角色id
     * @return 受影响记录条数
     */
    int removeRoleAndRolePermission(int roleId);

    /**
     * 修改角色表和角色权限中间表记录
     *
     * @param role 角色信息
     * @return 受影响记录条数
     */
    int updateRoleAndRolePermission(Role role);

    /**
     * 根据用户账号获取用户的角色信息
     *
     * @param account 用户账号
     * @return 对应用户的角色集合
     */
    List<Role> getRolesByAccount(String account);
}
