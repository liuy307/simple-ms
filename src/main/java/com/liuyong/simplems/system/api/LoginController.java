package com.liuyong.simplems.system.api;

import com.liuyong.simplems.common.annotation.UserLoginToken;
import com.liuyong.simplems.common.base.ExceptionHandlerController;
import com.liuyong.simplems.common.core.model.ApiResponse;
import com.liuyong.simplems.common.core.utils.JWTUtil;
import com.liuyong.simplems.system.ent.LoginInfo;
import com.liuyong.simplems.system.ent.Role;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.ent.UserInfo;
import com.liuyong.simplems.system.manager.UserManager;
import com.liuyong.simplems.system.service.MenuService;
import com.liuyong.simplems.system.service.RoleService;
import com.liuyong.simplems.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("login")
@Api(tags = "登录管理接口")
public class LoginController extends ExceptionHandlerController {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserManager userManager;

    @ApiOperation("登录验证")
    @PostMapping("/login")
    public ApiResponse login(LoginInfo loginInfo) {
        User user = userManager.getUser(loginInfo.getAccount());
        if(user == null){
            return ApiResponse.failed("用户名不存在！");
        }
        Set<String> roleNameSet = userManager.getRoleNameSet(loginInfo.getAccount());
        Set<String> menuNameSet = userManager.getMenuNameSet(loginInfo.getAccount());
        Set<String> permissionNameSet = userManager.getPermissionNameSet(loginInfo.getAccount());

        String token = JWTUtil.sign(loginInfo.getAccount(), loginInfo.getPassword());
        user.setPassword("this is a secret");

        UserInfo userInfo = new UserInfo();
        userInfo.setToken(token);
        userInfo.setUser(user);
        userInfo.setRoleNameSet(roleNameSet);
        userInfo.setMenuNameSet(menuNameSet);
        userInfo.setPermissionNameSet(permissionNameSet);
        return  ApiResponse.success(userInfo);
    }

    @ApiOperation("用户信息")
    @PostMapping("/getUserInfo")
    @UserLoginToken
    @RequiresPermissions("user:add")
    public ApiResponse getUserInfo(LoginInfo loginInfo) {
        return ApiResponse.success(loginInfo);
    }
}

