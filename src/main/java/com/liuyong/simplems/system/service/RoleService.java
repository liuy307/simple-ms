package com.liuyong.simplems.system.service;

import com.liuyong.simplems.common.base.BaseService;
import com.liuyong.simplems.system.dto.RoleDTO;
import com.liuyong.simplems.system.ent.Role;
import com.liuyong.simplems.system.vo.RoleVO;

import java.util.List;
/**
 * 角色Service接口
 *
 * @author liuyong
 * @date 2020/8/5 10:17
 */
public interface RoleService extends BaseService<Role> {
    /**
     * 根据用户账号获取用户的角色信息
     *
     * @param account 用户账号
     * @return 对应用户的角色集合
     */
    List<Role> getRolesByAccount(String account);

    /**
     * 查看角色菜单联合查询结果
     *
     * @param
     * @return
     */
    List<RoleVO> listRoleMenus();

    /**
     * 查看角色菜单联合查询结果（通过角色id）
     *
     * @param roleId 角色id
     * @return
     */
    RoleVO getRoleMenuById(int roleId);

    /**
     * 创建角色表和角色菜单中间表记录
     *
     * @param roleDto 待创建角色详细信息
     * @return 受影响记录条数
     */
    int saveRoleAndRoleMenu(RoleDTO roleDto);

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
     * @param roleDto 角色信息
     * @return 受影响记录条数
     */
    int updateRoleAndRoleMenu(RoleDTO roleDto);

    /**
     * 查看角色权限联合查询结果
     *
     * @param
     * @return
     */
    List<RoleVO> listRolePermissions();

    /**
     * 查看角色权限联合查询结果（通过角色id）
     *
     * @param roleId 角色id
     * @return
     */
    RoleVO getRolePermissionById(int roleId);

    /**
     * 创建角色表和角色权限中间表记录
     *
     * @param roleDto 待创建角色详细信息
     * @return 受影响记录条数
     */
    int saveRoleAndRolePermission(RoleDTO roleDto);

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
     * @param roleDto 待创建角色详细信息
     * @return 受影响记录条数
     */
    int updateRoleAndRolePermission(RoleDTO roleDto);


}
