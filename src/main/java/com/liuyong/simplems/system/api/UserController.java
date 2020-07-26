package com.liuyong.simplems.system.api;

import com.liuyong.simplems.common.base.BaseController;
import com.liuyong.simplems.common.core.model.ApiResponse;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
@Api(tags = "用户管理接口")
public class UserController extends BaseController<User>{
    @Autowired
    UserService userService;

    /*
     * @author : LiuYong
     * @date : 2020/7/24
     * @descrip: 新增人员，并返回新增人员Id
     * @param user 1
     * @return : ApiResponse<Integer>
     */
    @Override
    @ApiOperation("新增")
    @PostMapping("/save")
    public ApiResponse<Integer> save(User user) {
        int i = userService.save(user);
        return ApiResponse.success(user.getId());
    }

    /*
     * @author : LiuYong
     * @date : 2020/7/24
     * @descrip:
     * @param  1
     * @return : ApiResponse<List<User>>
     */
    @ApiOperation("列出人员角色信息")
    @PostMapping("/listUserRoles")
    ApiResponse<List<User>> listUserRoles() {
        return ApiResponse.success(userService.listUserRoles());
    }

    @ApiOperation("列出人员角色信息(根据id)")
    @PostMapping("/getUserRoleById")
    ApiResponse<User> getUserRoleById(int useId) {
        return ApiResponse.success(userService.getUserRoleById(useId));
    }

    @ApiOperation("新增用户表和用户角色中间表信息")
    @PostMapping("/saveUserAndUserRole")
    ApiResponse<Integer> saveUserAndUserRole(@RequestBody User user) {
        int flag = userService.saveUserAndUserRole(user);
        return ApiResponse.success(flag);
    }

    @ApiOperation("删除用户表和用户角色中间表信息")
    @PostMapping("/removeUserAndUserRole")
    ApiResponse<User> removeUserAndUserRole(int useId) {
        return ApiResponse.success(userService.removeUserAndUserRole(useId));
    }

    @ApiOperation("更新用户表和用户角色中间表信息")
    @PostMapping("/updateUserAndUserRole")
    ApiResponse<Integer> updateUserAndUserRole(User user) {
        int flag = userService.updateUserAndUserRole(user);
        return ApiResponse.success(flag);
    }
}
