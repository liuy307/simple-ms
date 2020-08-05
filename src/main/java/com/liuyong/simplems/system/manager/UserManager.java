package com.liuyong.simplems.system.manager;

import com.liuyong.simplems.system.dao.UserRoleMapper;
import com.liuyong.simplems.system.ent.Permission;
import com.liuyong.simplems.system.ent.Role;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.service.MenuService;
import com.liuyong.simplems.system.service.PermissionService;
import com.liuyong.simplems.system.service.RoleService;
import com.liuyong.simplems.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 自定义用户管理器
 *
 * @author liuyong
 * @date 2020/8/5 13:35
 */
@Service
public class UserManager {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @Autowired
    PermissionService permissionService;

    public User getUser(String account) {
        return userService.getUserByAccount(account);
    }

    public Set<String> getRoleNameSet(String account) {
        List<Role> roles = roleService.getRolesByAccount(account);
        return roles.stream().map(role -> role.getRoleName()).collect(Collectors.toSet());
    }

    public Set<String> getMenuNameSet(String account) {
        return new HashSet<String>(menuService.getMenuNameSetByAccount(account));
    }

    public Set<String> getPermissionNameSet(String account) {
        return new HashSet<String>(permissionService.getPermissionNameSetByAccount(account));
    }
}
