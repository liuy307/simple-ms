package com.liuyong.simplems.system.service;

import com.liuyong.simplems.common.base.BaseService;
import com.liuyong.simplems.system.ent.User;

import java.util.List;

public interface UserService extends BaseService<User> {
    List<User> listUserRoles();
    User getUserRoleById(int id);

    int saveUserAndUserRole(User user);
}
