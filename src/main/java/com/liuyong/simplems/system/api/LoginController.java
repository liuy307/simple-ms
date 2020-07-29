package com.liuyong.simplems.system.api;

import com.liuyong.simplems.common.base.ExceptionHandlerController;
import com.liuyong.simplems.common.core.model.ApiResponse;
import com.liuyong.simplems.common.core.utils.JWTUtil;
import com.liuyong.simplems.system.ent.LoginInfo;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.service.MenuService;
import com.liuyong.simplems.system.service.RoleService;
import com.liuyong.simplems.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("login")
@Api(tags = "登录管理接口")
public class LoginController extends ExceptionHandlerController {
    @Autowired
    UserService userService;

    @ApiOperation("登录验证")
    @PostMapping("/login")
    public ApiResponse login(LoginInfo loginInfo) {
        List<User> matchUsers = userService.listUserRoleMenusByLoginInfo(loginInfo);
        if(matchUsers ==null || matchUsers.size() < 1 ){
            return ApiResponse.failed("用户名不存在！");
        }
        User user = matchUsers.get(0);
        if(!Objects.equals(loginInfo.getPassword(), user.getPassword())) {
            return ApiResponse.failed("密码不正确！");
        }

        String token = JWTUtil.sign(loginInfo.getAccountNumber(), loginInfo.getPassword());
        loginInfo.setToken(token);
        return  ApiResponse.success(token);
    }

    @ApiOperation("用户信息")
    @PostMapping("/getUserInfo")
    public ApiResponse getUserInfo(LoginInfo loginInfo) {

    }
}

