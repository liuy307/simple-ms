package com.liuyong.simplems.system.service.impl;

import com.liuyong.simplems.common.base.BaseServiceImpl;
import com.liuyong.simplems.system.dao.*;
import com.liuyong.simplems.system.dto.RoleDTO;
import com.liuyong.simplems.system.ent.Role;
import com.liuyong.simplems.system.ent.RoleMenu;
import com.liuyong.simplems.system.ent.RolePermission;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.service.RoleService;
import com.liuyong.simplems.system.vo.RoleVO;
import org.springframework.beans.BeanUtils;
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

    @Override
    public List<Role> getRolesByAccount(String account) {
        return roleMapper.getRolesByAccount(account);
    }

    @Override
    public List<RoleVO> listRoleMenus() {
        return roleMapper.listRoleMenus();
    }

    @Override
    public RoleVO getRoleMenuById(int roleId) {
        return roleMapper.getRoleMenuById(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveRoleAndRoleMenu(RoleDTO roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);

        int flag1 = roleMapper.save(role);
        int roleId = roleDto.getId();

        List<String> menuNameList = roleDto.getMenuNameList();
        List<Integer> menuIdList = menuMapper.getIdByNameBatch(menuNameList);
        Assert.notEmpty(menuNameList, "菜单不能为空！");//传入菜单不能为空

        List<RoleMenu> roleMenuList = new ArrayList<>();
        menuIdList.stream().forEach(menuId -> {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            roleMenuList.add(roleMenu);});
        int flag2 = roleMenuMapper.saveBatch(roleMenuList);
        return (flag1>0&&flag2>0 ? flag2:0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeRoleAndRoleMenu(int roleId) {
        int flag1 = roleMapper.remove(roleId);
        int flag2 = roleMenuMapper.removeByRoleId(roleId);
        return (flag1>0&&flag2>0 ? flag2:0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateRoleAndRoleMenu(RoleDTO roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);

        int flag1 = roleMapper.update(role);
        int roleId = roleDto.getId();

        int flag2 = roleMenuMapper.removeByRoleId(roleId);

        List<String> menuNameList = roleDto.getMenuNameList();
        List<Integer> menuIdList = menuMapper.getIdByNameBatch(menuNameList);
        //传入菜单不能为空
        Assert.notEmpty(menuNameList, "菜单不能为空！");

        List<RoleMenu> roleMenuList = new ArrayList<>();
        menuIdList.stream().forEach(menuId -> {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            roleMenuList.add(roleMenu);});
        int flag3 = roleMenuMapper.saveBatch(roleMenuList);
        return (flag1>0&&flag2>0&&flag3>0 ? flag3:0);
    }

    @Override
    public List<RoleVO> listRolePermissions() {
        return roleMapper.listRolePermissions();
    }

    @Override
    public RoleVO getRolePermissionById(int roleId) {
        return roleMapper.getRolePermissionById(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveRoleAndRolePermission(RoleDTO roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);

        int flag1 = roleMapper.save(role);
        int roleId = roleDto.getId();

        List<String> permissionNameList = roleDto.getPermissionNameList();
        List<Integer> permissionIdList = permissionMapper.getIdByNameBatch(permissionNameList);
        Assert.notEmpty(permissionNameList, "菜单不能为空！");//传入菜单不能为空

        List<RolePermission> rolePermissionList = new ArrayList<>();
        permissionIdList.stream().forEach(menuId -> {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(menuId);
            rolePermissionList.add(rolePermission);});
        int flag2 = rolePermissionMapper.saveBatch(rolePermissionList);
        return (flag1>0&&flag2>0 ? flag2:0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeRoleAndRolePermission(int roleId) {
        int flag1 = roleMapper.remove(roleId);
        int flag2 = rolePermissionMapper.removeByRoleId(roleId);
        return (flag1>0&&flag2>0 ? flag2:0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateRoleAndRolePermission(RoleDTO roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);

        int flag1 = roleMapper.update(role);
        int roleId = roleDto.getId();

        int flag2 = rolePermissionMapper.removeByRoleId(roleId);

        List<String> permissionNameList = roleDto.getPermissionNameList();
        List<Integer> permissionIdList = permissionMapper.getIdByNameBatch(permissionNameList);
        //传入菜单不能为空
        Assert.notEmpty(permissionNameList, "权限不能为空！");

        List<RolePermission> rolePermissionList = new ArrayList<>();
        permissionIdList.stream().forEach(menuId -> {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(menuId);
            rolePermissionList.add(rolePermission);});
        int flag3 = rolePermissionMapper.saveBatch(rolePermissionList);
        return (flag1>0&&flag2>0&&flag3>0 ? flag3:0);
    }
}
