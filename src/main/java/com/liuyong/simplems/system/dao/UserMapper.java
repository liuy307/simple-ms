package com.liuyong.simplems.system.dao;

import com.liuyong.simplems.common.base.BaseMapper;
import com.liuyong.simplems.system.ent.LoginInfo;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.ent.UserRole;
import com.liuyong.simplems.system.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.shiro.authc.Account;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户账号获取用户信息
     *
     * @param account 用户账号
     * @return 对应用户
     */
    User getUserByAccount(String account);

    /**
     * 获取用户角色关联信息（UserVO）
     *
     * @param
     * @return 对应用户集合
     */
    List<UserVO> listUserRoles();

    /**
     * 获取用户角色关联信息（UserVO）
     *
     * @param account 用户账号
     * @return 对应用户
     */
    UserVO getUserRoleByAccount(String account);

    UserVO getUserRoleMenusPermissionsByAccount(String account);
}
