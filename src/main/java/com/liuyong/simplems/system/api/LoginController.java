package com.liuyong.simplems.system.api;

import com.liuyong.simplems.common.annotation.UserLoginToken;
import com.liuyong.simplems.common.base.ExceptionHandlerController;
import com.liuyong.simplems.common.core.model.ApiResponse;
import com.liuyong.simplems.common.core.utils.JWTUtil;
import com.liuyong.simplems.system.ent.LoginInfo;
import com.liuyong.simplems.system.ent.Role;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.ent.UserInfo;
import com.liuyong.simplems.system.service.MenuService;
import com.liuyong.simplems.system.service.RoleService;
import com.liuyong.simplems.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

//    @ApiOperation("登录验证")
//    @PostMapping("/login")
//    public ApiResponse login(LoginInfo loginInfo) {
//
//        String token = JWTUtil.sign(loginInfo.getAccount(), loginInfo.getPassword());
//        user.setPassword("this is a secret");
//        user.setRoleList(null);
//
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUser(user);
//        userInfo.setToken(token);
//        userInfo.setMenuNameSet(menuNameSet);
//        userInfo.setPermissionNameSet(permissionNameSet);
//        return  ApiResponse.success(userInfo);
//    }

//    public void getUserInfo(int s) {
//        List<User> matchUsers = userService.listUserRoleMenusByLoginInfo(loginInfo);
//        if(matchUsers ==null || matchUsers.size() < 1 ){
//            return ApiResponse.failed("用户名不存在！");
//        }
//        User user = matchUsers.get(0);
//        if(!Objects.equals(loginInfo.getPassword(), user.getPassword())) {
//            return ApiResponse.failed("密码不正确！");
//        }
//
//        List<Integer> roleIdList = user.getRoleList().stream().map(role -> role.getId()).collect(Collectors.toList());
//        Set<String> roleNameSet = user.getRoleList().stream().map(role -> role.getRoleName()).collect(Collectors.toSet());
//        List<Role> roleMenuList = roleIdList.stream().map(roleId -> roleService.getRoleMenuById(roleId)).collect(Collectors.toList());
//        List<Role> rolePermissionList = roleIdList.stream().map(roleId -> roleService.getRolePermissionById(roleId)).collect(Collectors.toList());
//        Set<String> menuNameSet = new HashSet<>();
//        Set<String> permissionNameSet = new HashSet<>();
//        roleMenuList.stream().forEach(roleMenu -> roleMenu.getMenuList().stream().forEach(menu -> menuNameSet.add(menu.getMenuName())));
//        rolePermissionList.stream().forEach(rolePermission -> rolePermission.getPermissionList().stream().forEach(permission -> permissionNameSet.add(permission.getPermissionName())));
//
//    }

    @ApiOperation("用户信息")
    @PostMapping("/getUserInfo")
    @UserLoginToken
    public ApiResponse getUserInfo(LoginInfo loginInfo, int s) {
        return ApiResponse.success(loginInfo);
    }
}

