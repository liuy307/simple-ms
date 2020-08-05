package com.liuyong.simplems.system.dao;

import com.liuyong.simplems.common.base.BaseMapper;
import com.liuyong.simplems.system.ent.LoginInfo;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.ent.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.shiro.authc.Account;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> listUserRoles();

    User getUserRoleById(int id);

    List<User> listUserRoleMenusByLoginInfo(LoginInfo loginInfo);

    List<User> listUserRoleMenusByAccount(String account);

    List<User> listUserRoleMenusPermissionsByLoginInfo(LoginInfo loginInfo);

    /**
     * 根据用户账号获取用户信息
     *
     * @param account 用户账号
     * @return 对应用户
     */
    User getUserByAccount(String account);
}
