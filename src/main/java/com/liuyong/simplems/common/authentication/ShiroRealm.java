package com.liuyong.simplems.common.authentication;

import com.liuyong.simplems.common.core.utils.JWTUtil;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.manager.UserManager;
import com.liuyong.simplems.system.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * 自定义实现 ShiroRealm，包含认证和授权两大模块
 *
 * @author liuyong
 * @date 2020/8/5 17:49
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    @Autowired
    UserManager userManager;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 用户认证
     *
     * @param authenticationToken 身份认证token
     * @return 身份认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String account = JWTUtil.getUsername(token);
        if (account == null) {
            throw new AuthenticationException("token invalid");
        }

        List<User> userBeans = userService.listUserRoleMenusByAccount(account);
        if (userBeans == null) {
            throw new AuthenticationException("User didn't existed!");
        }
        User userBean = userBeans.get(0);
        if (! JWTUtil.verify(token, account, userBean.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }

    /**
     * 用户授权，获取用户角色和权限
     *
     * @param principalCollection token
     * @return org.apache.shiro.authz.AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String account = JWTUtil.getUsername(principalCollection.toString());

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 获取用户角色集
        Set<String> roleSet = userManager.getRoleNameSet(account);
        simpleAuthorizationInfo.setRoles(roleSet);

        // 获取用户权限集
        Set<String> permissionSet = userManager.getPermissionNameSet(account);
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }
}
