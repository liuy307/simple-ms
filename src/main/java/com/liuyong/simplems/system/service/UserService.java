package com.liuyong.simplems.system.service;

import com.liuyong.simplems.common.base.BaseService;
import com.liuyong.simplems.system.ent.LoginInfo;
import com.liuyong.simplems.system.ent.User;
import org.apache.shiro.authc.Account;

import java.util.List;

/**
 * @description: 用户Service接口
 * @author: liuyong
 * @create: 2020/8/4 17:39
 */
public interface UserService extends BaseService<User> {
    /**
     * @description: 查看用户角色表联合查询结果
     * @param:
     * @return:
     */
    List<User> listUserRoles();

    /**
     * @description: 查看用户角色表联合查询结果（通过用户id）
     * @param:
     * @return:
     */
    User getUserRoleById(int userId);

    /**
     * @description: 创建用户表和用户角色中间表记录
     * @param: user 用户信息
     * @return: int 受影响记录条数
     */
    int saveUserAndUserRole(User user);

    /**
     * @description: 删除用户表和用户角色中间表记录
     * @param: userId 用户Id
     * @return: int 受影响记录条数
     */
    int removeUserAndUserRole(int userId);

    /**
     * @description: 更新用户表和用户角色中间表记录
     * @param: user 用户信息
     * @return: int 受影响记录条数
     */
    int updateUserAndUserRole(User user);

    /**
     * @description: 返回用户角色菜单联合查询结果（通过用户登录信息）
     * @param: loginInfo 用户登录信息
     * @return:
     */
    List<User> listUserRoleMenusByLoginInfo(LoginInfo loginInfo);

    /**
     * @description: 返回用户角色菜单联合查询结果（通过用户账号）
     * @param: account 用户账号
     * @return:
     */
    List<User> listUserRoleMenusByAccount(String account);
}
