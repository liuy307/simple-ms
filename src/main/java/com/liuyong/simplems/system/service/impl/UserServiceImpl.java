package com.liuyong.simplems.system.service.impl;

import com.liuyong.simplems.common.base.BaseServiceImpl;
import com.liuyong.simplems.system.dao.RoleMapper;
import com.liuyong.simplems.system.dao.UserMapper;
import com.liuyong.simplems.system.dao.UserRoleMapper;
import com.liuyong.simplems.system.dto.UserDTO;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.ent.UserRole;
import com.liuyong.simplems.system.service.UserService;
import com.liuyong.simplems.system.vo.UserVO;
import org.springframework.beans.BeanUtils;
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
    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }

    @Override
    public List<UserVO> listUserRoles() {
        return userMapper.listUserRoles();
    }

    @Override
    public UserVO getUserRoleByAccount(String account) {
        return userMapper.getUserRoleByAccount(account);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveUserAndUserRole(UserDTO userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);

        int flag1 = userMapper.save(userDto);
        int userId = userDto.getId();

        List<String> roleNameList = userDto.getRoleNameList();
        List<Integer> roleIdList = roleMapper.getIdByNameBatch(roleNameList);
        Assert.notEmpty(roleNameList, "角色不能为空！");//传入角色不能为空

        List<UserRole> userRoleList = new ArrayList<>();
        roleIdList.stream().forEach(roleId -> {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRoleList.add(userRole);});
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
    public int updateUserAndUserRole(UserDTO userDto) {
        int flag1 = userMapper.update(userDto);
        int userId = userDto.getId();

        int flag2 = userRoleMapper.removeByUserId(userId);

        List<String> roleNameList = userDto.getRoleNameList();
        List<Integer> roleIdList = roleMapper.getIdByNameBatch(roleNameList);
        Assert.notEmpty(roleNameList, "角色不能为空！");//传入角色不能为空

        List<UserRole> userRoleList = new ArrayList<>();
        roleIdList.stream().forEach(roleId -> {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRoleList.add(userRole);});
        int flag3 = userRoleMapper.saveBatch(userRoleList);
        return (flag1>0&&flag2>0&&flag3>0 ? flag3:0);
    }


}
