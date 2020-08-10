package com.liuyong.simplems.system.service.impl;

import com.liuyong.simplems.common.base.BaseServiceImpl;
import com.liuyong.simplems.system.dao.RoleMapper;
import com.liuyong.simplems.system.dao.UserMapper;
import com.liuyong.simplems.system.dao.UserRoleMapper;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.ent.UserRole;
import com.liuyong.simplems.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<User> listUserRoles() {
        return userMapper.listUserRoles();
    }

    @Override
    public User getUserRoleByAccount(String account) {
        return userMapper.getUserRoleByAccount(account);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveUserAndUserRole(User user) {
        int flag1 = userMapper.save(user);
        int userId = user.getId();

        List<String> roleNameList = user.getRoleNameList();
        List<Integer> roleIdList = roleMapper.getIdByNameBatch(roleNameList);
        Assert.notEmpty(roleNameList, "角色不能为空！");//传入角色不能为空

        List<UserRole> userRoleList = new ArrayList<>();
        for (int i = 0; i < roleIdList.size(); i++) {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleIdList.get(i));
            userRoleList.add(userRole);
        }
        int flag2 = userRoleMapper.saveBatch(userRoleList);
        return (flag1>0&&flag2>0 ? flag2:0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeUserAndUserRole(int userId) {
        int flag1 = userMapper.remove(userId);
        int flag2 = userRoleMapper.removeByUserId(userId);
        return (flag1>0&&flag2>0 ? flag2:0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUserAndUserRole(User user) {
        int flag1 = userMapper.update(user);
        int userId = user.getId();

        int flag2 = userRoleMapper.removeByUserId(userId);

        List<String> roleNameList = user.getRoleNameList();
        List<Integer> roleIdList = roleMapper.getIdByNameBatch(roleNameList);
        Assert.notEmpty(roleNameList, "角色不能为空！");//传入角色不能为空
        List<UserRole> userRoleList = new ArrayList<>();
        for (int i = 0; i < roleIdList.size(); i++) {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleIdList.get(i));
            userRoleList.add(userRole);
        }
        int flag3 = userRoleMapper.saveBatch(userRoleList);
        return (flag1>0&&flag2>0&&flag3>0 ? flag3:0);
    }

    @Override
    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }
}
