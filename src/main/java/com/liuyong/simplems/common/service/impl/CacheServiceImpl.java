package com.liuyong.simplems.common.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuyong.simplems.common.core.utils.FebsUtil;
import com.liuyong.simplems.common.domain.FebsConstant;
import com.liuyong.simplems.common.service.CacheService;
import com.liuyong.simplems.common.service.RedisService;
import com.liuyong.simplems.exception.RedisConnectException;
import com.liuyong.simplems.system.ent.Permission;
import com.liuyong.simplems.system.ent.Role;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.service.MenuService;
import com.liuyong.simplems.system.service.PermissionService;
import com.liuyong.simplems.system.service.RoleService;
import com.liuyong.simplems.system.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 用户相关redis缓存操作接口实现类
 *
 * @author liuyong
 * @date 2020/8/7 15:22
 */
@Service
public class CacheServiceImpl implements CacheService {
    @Autowired
    RedisService redisService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @Autowired
    PermissionService permissionService;



    /**
     * 将用户信息添加到至redis缓存
     *
     * @param account 用户账号
     * @return
     */
    @Override
    public void saveUserByAccount(String account) throws JsonProcessingException, RedisConnectException {
        User user = userService.getUserByAccount(account);
        redisService.set(FebsConstant.USER_CACHE_PREFIX + account, objectMapper.writeValueAsString(user));
    }

    /**
     * 先查询数据库，将用户的角色信息添加到至redis缓存
     *
     * @param account 用户账号
     * @return
     */
    @Override
    public void saveRolesByAccount(String account) throws JsonProcessingException, RedisConnectException {
        List<Role> roleList = roleService.getRolesByAccount(account);
        if (!roleList.isEmpty()) {
            redisService.set(FebsConstant.USER_ROLE_CACHE_PREFIX + account, objectMapper.writeValueAsString(roleList));
        }
    }

    /**
     * 先查询数据库，再将用户的权限信息添加到至redis缓存
     *
     * @param account 用户账号
     * @return
     */
    @Override
    public void savePermissionsByAccount(String account) throws JsonProcessingException, RedisConnectException {
        List<Permission> permissionList = permissionService.getPermissionsByAccount(account);
        if (!permissionList.isEmpty()) {
            redisService.set(FebsConstant.USER_PERMISSION_CACHE_PREFIX + account, objectMapper.writeValueAsString(permissionList));
        }
    }

    /**
     * 从缓存中获取用户信息
     *
     * @param account 用户账号
     * @return void
     */
    @Override
    public User getUserByAccount(String account) throws Exception {
        String userString = redisService.get(FebsConstant.USER_CACHE_PREFIX + account);
        if (StringUtils.isBlank(userString))
            throw new Exception();
        else {
            return objectMapper.readValue(userString, User.class);
        }
    }

    /**
     * 从缓存中获取角色信息
     *
     * @param account 用户账号
     * @return void
     */
    @Override
    public List<Role> getRolesByAccount(String account) throws Exception {
        String roleListString = this.redisService.get(FebsConstant.USER_ROLE_CACHE_PREFIX + account);
        if (StringUtils.isBlank(roleListString)) {
            throw new Exception();
        } else {
            JavaType type = objectMapper.getTypeFactory().constructParametricType(List.class, Role.class);
            return objectMapper.readValue(roleListString, type);
        }
    }

    /**
     * 从缓存中获取权限信息
     *
     * @param account 用户账号
     * @return void
     */
    @Override
    public List<Permission> getPermissionsByAccount(String account) throws Exception {
        String permissionListString = this.redisService.get(FebsConstant.USER_PERMISSION_CACHE_PREFIX + account);
        if (StringUtils.isBlank(permissionListString)) {
            throw new Exception();
        } else {
            JavaType type = objectMapper.getTypeFactory().constructParametricType(List.class, Permission.class);
            return objectMapper.readValue(permissionListString, type);
        }
    }
}
