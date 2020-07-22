package com.liuyong.simplems.system.service;

import com.liuyong.simplems.system.ent.User;

import java.util.List;

public interface UserService {
    List<User> listAll();
    int createUser(User user);
}
