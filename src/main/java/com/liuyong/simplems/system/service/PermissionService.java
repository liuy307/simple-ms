package com.liuyong.simplems.system.service;

import com.liuyong.simplems.common.base.BaseService;
import com.liuyong.simplems.system.ent.Menu;
import com.liuyong.simplems.system.ent.Permission;

import java.util.List;
import java.util.Set;

public interface PermissionService extends BaseService<Permission> {
    /**
     * 通过用户账号返回用户拥有的权限集
     *
     * @param account 用户账号
     * @return 权限集合
     */
    Set<String> getPermissionNameSetByAccount(String account);
}
