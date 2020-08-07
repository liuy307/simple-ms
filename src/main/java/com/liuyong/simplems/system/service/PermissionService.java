package com.liuyong.simplems.system.service;

import com.liuyong.simplems.common.base.BaseService;
import com.liuyong.simplems.system.ent.Permission;

import java.util.List;

public interface PermissionService extends BaseService<Permission> {
    /**
     * 通过用户账号返回用户拥有的权限集
     *
     * @param account 用户账号
     * @return 权限集合
     */
    List<Permission> getPermissionsByAccount(String account);
}
