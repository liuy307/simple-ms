package com.liuyong.simplems.system.api;

import com.liuyong.simplems.common.base.BaseController;
import com.liuyong.simplems.common.core.model.ApiResponse;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
@Api(tags = "用户管理接口")
public class UserController extends BaseController<User>{
    @Autowired
    UserService userService;

    @Override
    @ApiOperation("增加")
    @PostMapping("/save")
    public ApiResponse<Integer> save(User user) {
        int i = userService.save(user);
        return ApiResponse.success(user.getId());
    }

    @ApiOperation("列出人员角色关联表")
    @PostMapping("/listUserRoles")
    ApiResponse<List<User>> listUserRoles() {
        return ApiResponse.success(userService.listUserRoles());
    }

    @ApiOperation("列出人员角色关联表(根据id)")
    @PostMapping("/getUserRoleById")
    ApiResponse<User> getUserRoleById(int id) {
        return ApiResponse.success(userService.getUserRoleById(id));
    }

    @ApiOperation("新增人员表和人员角色表信息")
    @PostMapping("/saveUserAndUserRole")
    ApiResponse<Integer> saveUserAndUserRole(User user) {
        int flag = userService.saveUserAndUserRole(user);
        return ApiResponse.success(flag);
    }
}
