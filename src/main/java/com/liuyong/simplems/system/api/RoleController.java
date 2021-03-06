package com.liuyong.simplems.system.api;

import com.liuyong.simplems.common.base.BaseController;
import com.liuyong.simplems.common.base.ExceptionHandlerController;
import com.liuyong.simplems.common.core.model.ApiResponse;
import com.liuyong.simplems.system.dto.RoleDTO;
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
    ApiResponse listRoleMenus() {
        return ApiResponse.success(roleService.listRoleMenus());
    }

    @ApiOperation("列出角色菜单信息(根据id)")
    @PostMapping("/getRoleMenuById")
    ApiResponse getRoleMenuById(int roleId) {
        return ApiResponse.success(roleService.getRoleMenuById(roleId));
    }

    @ApiOperation("新增角色表和角色菜单中间表信息")
    @PostMapping("/saveRoleAndRoleMenu")
    ApiResponse saveRoleAndRoleMenu(RoleDTO roleDto) {
        int flag = roleService.saveRoleAndRoleMenu(roleDto);
        return ApiResponse.success(flag);
    }

    @ApiOperation("删除角色表和角色菜单中间表信息")
    @PostMapping("/removeRoleAndRoleMenu")
    ApiResponse removeRoleAndRoleMenu(int roleId) {
        return ApiResponse.success(roleService.removeRoleAndRoleMenu(roleId));
    }

    @ApiOperation("更新角色表和角色菜单中间表信息")
    @PostMapping("/updateRoleAndRoleMenu")
    ApiResponse updateRoleAndRoleMenu(RoleDTO roleDto) {
        int flag = roleService.updateRoleAndRoleMenu(roleDto);
        return ApiResponse.success(flag);
    }

    @ApiOperation("列出角色权限信息")
    @PostMapping("/listRolePermissions")
    ApiResponse listRolePermissions() {
        return ApiResponse.success(roleService.listRolePermissions());
    }

    @ApiOperation("列出角色权限信息(根据id)")
    @PostMapping("/getRolePermissionById")
    ApiResponse getRolePermissionById(int roleId) {
        return ApiResponse.success(roleService.getRolePermissionById(roleId));
    }

    @ApiOperation("新增角色表和角色权限中间表信息")
    @PostMapping("/saveRoleAndRolePermission")
    ApiResponse saveRoleAndRolePermission(RoleDTO roleDto) {
        int flag = roleService.saveRoleAndRolePermission(roleDto);
        return ApiResponse.success(flag);
    }

    @ApiOperation("删除角色表和角色权限中间表信息")
    @PostMapping("/removeRoleAndRolePermission")
    ApiResponse removeRoleAndRolePermission(int roleId) {
        return ApiResponse.success(roleService.removeRoleAndRolePermission(roleId));
    }

    @ApiOperation("更新角色表和角色权限中间表信息")
    @PostMapping("/updateRoleAndRolePermission")
    ApiResponse updateRoleAndRolePermission(RoleDTO roleDto) {
        int flag = roleService.updateRoleAndRolePermission(roleDto);
        return ApiResponse.success(flag);
    }
}
