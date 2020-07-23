package com.liuyong.simplems.system.service.impl;

import com.liuyong.simplems.common.base.BaseService;
import com.liuyong.simplems.common.base.BaseServiceImpl;
import com.liuyong.simplems.system.dao.UserMapper;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> listUsers() {
        return userMapper.listUsers();
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int removeUser(int id) {
        return userMapper.removeUser(id);
    }
}
