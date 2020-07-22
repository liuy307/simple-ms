package com.liuyong.simplems.system.service.impl;

import com.liuyong.simplems.system.dao.UserMapper;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }

    public int createUser(User user) {
        return userMapper.createUser(user);
    }
}
