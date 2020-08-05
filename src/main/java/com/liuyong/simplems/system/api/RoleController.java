package com.liuyong.simplems.system.api;

import com.liuyong.simplems.common.base.BaseController;
import com.liuyong.simplems.common.base.ExceptionHandlerController;
import com.liuyong.simplems.common.core.model.ApiResponse;
import com.liuyong.simplems.system.ent.Role;
import com.liuyong.simplems.system.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("role")
@Api(tags = "角色管理接口")
public class RoleController extends ExceptionHandlerController {
    @Autowired
    RoleService roleService;

    @ApiOperation("列出角色菜单信息")
    @PostMapping("/listRoleMenus")
    ApiResponse<List<Role>> listRoleMenus() {
        return ApiResponse.success(roleService.listRoleMenus());
    }

    @ApiOperation("列出角色菜单信息(根据id)")
    @PostMapping("/getRoleMenuById")
    ApiResponse<Role> getRoleMenuById(int roleId) {
        return ApiResponse.success(roleService.getRoleMenuById(roleId));
    }

    @ApiOperation("新增角色表和角色菜单中间表信息")
    @PostMapping("/saveRoleAndRoleMenu")
    ApiResponse<Integer> saveRoleAndRoleMenu(Role user) {
        int flag = roleService.saveRoleAndRoleMenu(user);
        return ApiResponse.success(flag);
    }

    @ApiOperation("删除角色表和角色菜单中间表信息")
    @PostMapping("/removeRoleAndRoleMenu")
    ApiResponse<Role> removeRoleAndRoleMenu(int roleId) {
        return ApiResponse.success(roleService.removeRoleAndRoleMenu(roleId));
    }

    @ApiOperation("更新角色表和角色菜单中间表信息")
    @PostMapping("/updateRoleAndRoleMenu")
    ApiResponse<Integer> updateRoleAndRoleMenu(Role user) {
        int flag = roleService.updateRoleAndRoleMenu(user);
        return ApiResponse.success(flag);
    }

    @ApiOperation("列出角色权限信息")
    @PostMapping("/listRolePermissions")
    ApiResponse<List<Role>> listRolePermissions() {
        return ApiResponse.success(roleService.listRolePermissions());
    }

    @ApiOperation("列出角色权限信息(根据id)")
    @PostMapping("/getRolePermissionById")
    ApiResponse<Role> getRolePermissionById(int roleId) {
        return ApiResponse.success(roleService.getRolePermissionById(roleId));
    }

    @ApiOperation("新增角色表和角色权限中间表信息")
    @PostMapping("/saveRoleAndRolePermission")
    ApiResponse<Integer> saveRoleAndRolePermission(Role user) {
        int flag = roleService.saveRoleAndRolePermission(user);
        return ApiResponse.success(flag);
    }

    @ApiOperation("删除角色表和角色权限中间表信息")
    @PostMapping("/removeRoleAndRolePermission")
    ApiResponse<Role> removeRoleAndRolePermission(int roleId) {
        return ApiResponse.success(roleService.removeRoleAndRolePermission(roleId));
    }

    @ApiOperation("更新角色表和角色权限中间表信息")
    @PostMapping("/updateRoleAndRolePermission")
    ApiResponse<Integer> updateRoleAndRolePermission(Role user) {
        int flag = roleService.updateRoleAndRolePermission(user);
        return ApiResponse.success(flag);
    }
}
