package com.liuyong.simplems.system.dao;

import com.liuyong.simplems.common.base.BaseMapper;
import com.liuyong.simplems.system.ent.UserRole;

import java.util.List;

public interface UserRoleMapper extends BaseMapper<UserRole> {
    int saveBatch(List<UserRole> userRoleList);

    int removeUserRole(int userId);
}
