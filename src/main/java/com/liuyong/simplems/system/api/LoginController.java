package com.liuyong.simplems.system.api;

import com.liuyong.simplems.common.base.BaseController;
import com.liuyong.simplems.common.base.ExceptionHandlerController;
import com.liuyong.simplems.common.core.model.ApiResponse;
import com.liuyong.simplems.system.ent.LoginInfo;
import com.liuyong.simplems.system.ent.Menu;
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

@RestController
@RequestMapping("login")
@Api(tags = "登录管理接口")
public class LoginController extends ExceptionHandlerController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;

    @ApiOperation("登录验证")
    @PostMapping("/login")
    public List<User> login(LoginInfo loginInfo) {
        List<User> matchUsers = userService.getUserRoleByLoginInfo(loginInfo);
        return  matchUsers;
    }
}

