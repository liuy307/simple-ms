package com.liuyong.simplems.system.service;

import com.liuyong.simplems.common.base.BaseService;
import com.liuyong.simplems.system.ent.LoginInfo;
import com.liuyong.simplems.system.ent.User;

import java.util.List;

public interface UserService extends BaseService<User> {
    List<User> listUserRoles();
    User getUserRoleById(int userId);

    int saveUserAndUserRole(User user);

    int removeUserAndUserRole(int userId);

    int updateUserAndUserRole(User user);

    List<User> getUserRoleByLoginInfo(LoginInfo loginInfo);
}
