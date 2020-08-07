package com.liuyong.simplems.system.manager;

import com.liuyong.simplems.common.core.utils.FebsUtil;
import com.liuyong.simplems.common.domain.FebsConstant;
import com.liuyong.simplems.common.service.CacheService;
import com.liuyong.simplems.system.dao.UserRoleMapper;
import com.liuyong.simplems.system.ent.Menu;
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
    CacheService cacheService;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @Autowired
    PermissionService permissionService;

    /**
     * 将用户相关信息添加到 redis缓存中
     *
     * @param user user
     * @return void
     */
    public void loadUserRedisCache(User user) throws Exception {
        String account = user.getAccount();
        cacheService.saveUserByAccount(account);
        cacheService.saveRolesByAccount(account);
        cacheService.savePermissionsByAccount(account);
    }

    /**
     * 获取用户信息，优先查询缓存
     *
     * @param account 用户账号
     * @return 用户
     */
    public User getUser(String account) {
        return FebsUtil.selectCacheByTemplate(
                () -> cacheService.getUserByAccount(account),
                () -> userService.getUserByAccount(account));
    }

    /**
     * 获取角色信息，优先查询缓存
     *
     * @param account 用户账号
     * @return 角色集
     */
    public Set<String> getRoleNameSet(String account) {

        List<Role> roles = FebsUtil.selectCacheByTemplate(
                () -> cacheService.getRolesByAccount(account),
                () -> roleService.getRolesByAccount(account));
        return roles.stream().map(role -> role.getRoleName()).collect(Collectors.toSet());
    }

    /**
     * 获取权限信息，优先查询缓存
     *
     * @param account 用户账号
     * @return 权限集
     */
    public Set<String> getPermissionNameSet(String account) {
        List<Permission> permissions =  FebsUtil.selectCacheByTemplate(
                () -> cacheService.getPermissionsByAccount(account),
                () -> permissionService.getPermissionsByAccount(account));
        return permissions.stream().map(permission -> permission.getPermissionName()).collect(Collectors.toSet());
    }

    /**
     * 获取菜单信息，优先查询缓存
     *
     * @param account 用户账号
     * @return 角色集
     */
    public Set<String> getMenuNameSet(String account) {
        List<Menu> menus = menuService.getMenusByAccount(account);
        return menus.stream().map(menu -> menu.getMenuName()).collect(Collectors.toSet());
    }
}
