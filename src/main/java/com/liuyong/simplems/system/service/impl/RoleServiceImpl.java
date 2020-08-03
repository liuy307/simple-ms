package com.liuyong.simplems.system.service.impl;

import com.liuyong.simplems.common.base.BaseServiceImpl;
import com.liuyong.simplems.system.dao.*;
import com.liuyong.simplems.system.ent.Role;
import com.liuyong.simplems.system.ent.RoleMenu;
import com.liuyong.simplems.system.ent.RolePermission;
import com.liuyong.simplems.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleMenuMapper roleMenuMapper;

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Autowired
    PermissionMapper permissionMapper;

    /**
     * 列出用户角色关联结果表
     * @return
     */
    @Override
    public List<Role> listRoleMenus() {
        return roleMapper.listRoleMenus();
    }

    // 获取角色菜单关联结果表（根据Id）
    @Override
    public Role getRoleMenuById(int roleId) {
        return roleMapper.getRoleMenuById(roleId);
    }

    // 创建角色信息，角色菜单中间表信息
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveRoleAndRoleMenu(Role role) {
        int flag1 = roleMapper.save(role);
        int roleId = role.getId();

        List<String> menuNameList = role.getMenuNameList();
        List<Integer> menuIdList = menuMapper.getIdByNameBatch(menuNameList);
        Assert.notEmpty(menuNameList, "菜单不能为空！");//传入菜单不能为空

        List<RoleMenu> roleMenuList = new ArrayList<>();
        for (int i = 0; i < menuIdList.size(); i++) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuIdList.get(i));
            roleMenuList.add(roleMenu);
        }
        int flag2 = roleMenuMapper.saveBatch(roleMenuList);
        return (flag1>0&&flag2>0 ? flag2:0);
    }

    // 删除角色信息，角色菜单中间表信息
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeRoleAndRoleMenu(int roleId) {
        int flag1 = roleMapper.remove(roleId);
        int flag2 = roleMenuMapper.removeByRoleId(roleId);
        return (flag1>0&&flag2>0 ? flag2:0);
    }

    // 更新角色信息，角色菜单中间表信息
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateRoleAndRoleMenu(Role role) {
        int flag1 = roleMapper.update(role);
        int roleId = role.getId();

        int flag2 = roleMenuMapper.removeByRoleId(roleId);

        List<String> menuNameList = role.getMenuNameList();
        List<Integer> menuIdList = menuMapper.getIdByNameBatch(menuNameList);
        //传入菜单不能为空
        Assert.notEmpty(menuNameList, "菜单不能为空！");

        List<RoleMenu> roleMenuList = new ArrayList<>();
        for (int i = 0; i < menuIdList.size(); i++) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuIdList.get(i));
            roleMenuList.add(roleMenu);
        }
        int flag3 = roleMenuMapper.saveBatch(roleMenuList);
        return (flag1>0&&flag2>0&&flag3>0 ? flag3:0);
    }

    //角色权限
    /**
     * 列出角色权限关联结果表
     * @return
     */
    @Override
    public List<Role> listRolePermissions() {
        return roleMapper.listRolePermissions();
    }

    // 获取角色权限关联结果表（根据Id）
    @Override
    public Role getRolePermissionById(int roleId) {
        return roleMapper.getRolePermissionById(roleId);
    }

    // 创建角色信息，角色权限中间表信息
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveRoleAndRolePermission(Role role) {
        int flag1 = roleMapper.save(role);
        int roleId = role.getId();

        List<String> permissionNameList = role.getPermissionNameList();
        List<Integer> permissionIdList = permissionMapper.getIdByNameBatch(permissionNameList);
        Assert.notEmpty(permissionNameList, "菜单不能为空！");//传入菜单不能为空

        List<RolePermission> rolePermissionList = new ArrayList<>();
        for (int i = 0; i < permissionIdList.size(); i++) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionIdList.get(i));
            rolePermissionList.add(rolePermission);
        }
        int flag2 = rolePermissionMapper.saveBatch(rolePermissionList);
        return (flag1>0&&flag2>0 ? flag2:0);
    }

    // 删除角色信息，角色权限中间表信息
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeRoleAndRolePermission(int roleId) {
        int flag1 = roleMapper.remove(roleId);
        int flag2 = rolePermissionMapper.removeByRoleId(roleId);
        return (flag1>0&&flag2>0 ? flag2:0);
    }

    // 更新角色信息，角色权限中间表信息
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateRoleAndRolePermission(Role role) {
        int flag1 = roleMapper.update(role);
        int roleId = role.getId();

        int flag2 = rolePermissionMapper.removeByRoleId(roleId);

        List<String> permissionNameList = role.getPermissionNameList();
        List<Integer> permissionIdList = permissionMapper.getIdByNameBatch(permissionNameList);
        //传入菜单不能为空
        Assert.notEmpty(permissionNameList, "权限不能为空！");

        List<RolePermission> rolePermissionList = new ArrayList<>();
        for (int i = 0; i < permissionIdList.size(); i++) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionIdList.get(i));
            rolePermissionList.add(rolePermission);
        }
        int flag3 = rolePermissionMapper.saveBatch(rolePermissionList);
        return (flag1>0&&flag2>0&&flag3>0 ? flag3:0);
    }
}
