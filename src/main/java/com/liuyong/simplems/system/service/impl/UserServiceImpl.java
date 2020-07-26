package com.liuyong.simplems.system.service.impl;

import com.liuyong.simplems.common.base.BaseServiceImpl;
import com.liuyong.simplems.system.dao.RoleMapper;
import com.liuyong.simplems.system.dao.UserMapper;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.ent.UserRole;
import com.liuyong.simplems.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    // 列出用户角色关联结果表
    @Override
    public List<User> listUserRoles() {
        return userMapper.listUserRoles();
    }

    // 获取用户角色关联结果表（根据Id）
    @Override
    public User getUserRoleById(int userId) {
        return userMapper.getUserRoleById(userId);
    }

    // 创建用户信息，用户角色中间表信息
    @Override
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
        int flag2 = userMapper.saveUserRoleBatch(userRoleList);
        return (flag1>0&&flag2>0 ? flag2:0);
    }

    // 删除用户信息，用户角色中间表信息
    @Override
    public int removeUserAndUserRole(int userId) {
        int flag1 = userMapper.remove(userId);
        int flag2 = userMapper.removeUserRole(userId);
        return (flag1>0&&flag2>0 ? flag2:0);
    }

    // 更新用户信息，用户角色中间表信息
    @Override
    public int updateUserAndUserRole(User user) {
        int flag1 = userMapper.update(user);
        int userId = user.getId();

        int flag2 = userMapper.removeUserRole(userId);

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
        int flag3 = userMapper.saveUserRoleBatch(userRoleList);
        return (flag1>0&&flag2>0&&flag3>0 ? flag3:0);
    }
}
