package com.liuyong.simplems.system.dao;

import com.liuyong.simplems.common.base.BaseMapper;
import com.liuyong.simplems.system.ent.LoginInfo;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.ent.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> listUserRoles();
    User getUserRoleById(int id);

    int saveUserRoleBatch(List<UserRole> userRoleList);

    int removeUserRole(int userId);

    List<User> listUserRoleMenusByLoginInfo(LoginInfo loginInfo);
}
