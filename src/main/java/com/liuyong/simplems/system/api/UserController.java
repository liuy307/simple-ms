package com.liuyong.simplems.system.api;

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
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("查询全部用户")
    @GetMapping("/listUsers")
    public ApiResponse<List<User>> listUsers() {
        return ApiResponse.success(userService.listUsers()) ;
    }

    @ApiOperation("按id查询用户")
    @GetMapping("/getUserById")
    public ApiResponse<User> getUserById(int id) {
        return ApiResponse.success(userService.getUserById(id));
    }

    @ApiOperation("增加用户")
    @PostMapping("/saveUser")
    public ApiResponse<Integer> saveUser(User user) {
        return ApiResponse.success(userService.saveUser(user)) ;
    }

    @ApiOperation("修改用户")
    @PostMapping("/updateUser")
    public ApiResponse<Integer> updateUser(User user) {
        return ApiResponse.success(userService.updateUser(user));
    }

    @ApiOperation("删除用户")
    @GetMapping("/removeUser")
    public ApiResponse<Integer> removeUser(int id) {
        return ApiResponse.success(userService.removeUser(id));
    }

}
