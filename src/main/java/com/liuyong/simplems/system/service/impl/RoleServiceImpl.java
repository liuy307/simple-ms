package com.liuyong.simplems.system.service.impl;

import com.liuyong.simplems.common.base.BaseServiceImpl;
import com.liuyong.simplems.system.dao.MenuMapper;
import com.liuyong.simplems.system.dao.RoleMapper;
import com.liuyong.simplems.system.ent.Role;
import com.liuyong.simplems.system.ent.RoleMenu;
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
    MenuMapper menuMapper;
    // 列出用户角色关联结果表
    @Override
    public List<Role> listRoleMenus() {
        return roleMapper.listRoleMenus();
    }

    // 获取用户角色关联结果表（根据Id）
    @Override
    public Role getRoleMenuById(int roleId) {
        return roleMapper.getRoleMenuById(roleId);
    }

    // 创建用户信息，用户角色中间表信息
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
        int flag2 = roleMapper.saveRoleMenuBatch(roleMenuList);
        return (flag1>0&&flag2>0 ? flag2:0);
    }

    // 删除用户信息，用户角色中间表信息
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeRoleAndRoleMenu(int roleId) {
        int flag1 = roleMapper.remove(roleId);
        int flag2 = roleMapper.removeRoleMenu(roleId);
        return (flag1>0&&flag2>0 ? flag2:0);
    }

    // 更新用户信息，用户角色中间表信息
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateRoleAndRoleMenu(Role role) {
        int flag1 = roleMapper.update(role);
        int roleId = role.getId();

        int flag2 = roleMapper.removeRoleMenu(roleId);

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
        int flag3 = roleMapper.saveRoleMenuBatch(roleMenuList);
        return (flag1>0&&flag2>0&&flag3>0 ? flag3:0);
    }
}
