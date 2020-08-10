package com.liuyong.simplems.system.service;

import com.liuyong.simplems.common.base.BaseService;
import com.liuyong.simplems.system.dto.UserDTO;
import com.liuyong.simplems.system.ent.LoginInfo;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.vo.UserVO;
import org.apache.shiro.authc.Account;

import java.util.List;

/**
 * 用户Service接口
 *
 * @author liuyong
 * @date 2020/8/4 17:39
 */
public interface UserService extends BaseService<User> {
    /**
     * 根据用户账号获取用户信息
     *
     * @param account 用户账号
     * @return 对应用户
     */
    User getUserByAccount(String account);

    /**
     * 查看用户角色表联合查询结果
     *
     * @param
     * @return
     */
    List<UserVO> listUserRoles();

    /**
     * 查看用户角色表联合查询结果（通过用户id）
     *
     * @param account 用户账号
     * @return
     */
    UserVO getUserRoleByAccount(String account);

    /**
     * 创建用户表和用户角色中间表记录
     *
     * @param userDto 用户信息
     * @return 受影响记录条数
     */
    int saveUserAndUserRole(UserDTO userDto);

    /**
     * 删除用户表和用户角色中间表记录
     *
     * @param userId 用户id
     * @return 受影响记录条数
     */
    int removeUserAndUserRole(int userId);

    /**
     * 修改用户表和用户角色中间表记录
     *
     * @param userDto 用户信息
     * @return 受影响记录条数
     */
    int updateUserAndUserRole(UserDTO userDto);
}
