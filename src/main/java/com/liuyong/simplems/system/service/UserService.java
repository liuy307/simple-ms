package com.liuyong.simplems.system.service;

import com.liuyong.simplems.common.base.BaseService;
import com.liuyong.simplems.system.ent.User;

import java.util.List;

public interface UserService extends BaseService<User> {
    List<User> listUsers();

    User getUserById(int id);

    int saveUser(User user);

    int updateUser(User user);

    int removeUser(int id);
}
