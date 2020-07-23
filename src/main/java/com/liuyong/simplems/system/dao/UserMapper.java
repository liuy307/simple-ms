package com.liuyong.simplems.system.dao;

import com.liuyong.simplems.system.ent.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper{
    List<User> listUsers();

    User getUserById(int id);

    int saveUser(User user);

    int updateUser(User user);

    int removeUser(int id);
}
