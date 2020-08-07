package com.liuyong.simplems.common.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liuyong.simplems.exception.RedisConnectException;
import com.liuyong.simplems.system.ent.Permission;
import com.liuyong.simplems.system.ent.Role;
import com.liuyong.simplems.system.ent.User;

import java.util.List;

/**
 * @description 用户相关redis缓存操作接口
 *
 * @author liuyong
 * @date 2020/8/7 15:22
 */
public interface CacheService {
    /**
     * 将用户信息添加到至redis缓存
     *
     * @param account 用户账号
     * @return
     */
    void saveUserByAccount(String account) throws JsonProcessingException, RedisConnectException;

    /**
     * 先查询数据库，将用户的角色信息添加到至redis缓存
     *
     * @param account 用户账号
     * @return
     */
    void saveRolesByAccount(String account) throws JsonProcessingException, RedisConnectException;

    /**
     * 先查询数据库，再将用户的权限信息添加到至redis缓存
     *
     * @param account 用户账号
     * @return
     */
    void savePermissionsByAccount(String account) throws JsonProcessingException, RedisConnectException;

    /**
     * 从缓存中获取用户信息
     *
     * @param account 用户账号
     * @return void
     */
    User getUserByAccount(String account) throws Exception;

    /**
     * 从缓存中获取角色信息
     *
     * @param account 用户账号
     * @return void
     */
    List<Role> getRolesByAccount(String account) throws Exception;

    /**
     * 从缓存中获取权限信息
     *
     * @param account 用户账号
     * @return void
     */
    List<Permission> getPermissionsByAccount(String account) throws Exception;
}
