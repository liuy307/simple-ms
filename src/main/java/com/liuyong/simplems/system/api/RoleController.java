package com.liuyong.simplems.system.api;

import com.liuyong.simplems.common.core.model.ApiResponse;
import com.liuyong.simplems.system.ent.Role;
import com.liuyong.simplems.system.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("role")
@Api(tags = "角色管理接口")
public class RoleController {
    @Autowired
    RoleService roleService;

    @ApiOperation("查询全部角色")
    @GetMapping("/listRoles")
    public ApiResponse<List<Role>> listRoles() {
        return ApiResponse.success(roleService.list()) ;
    }

    @ApiOperation("按id查询角色")
    @GetMapping("/getRoleById")
    public ApiResponse<Role> getRoleById(int id) {
        return ApiResponse.success(roleService.getById(id));
    }

    @ApiOperation("增加角色")
    @PostMapping("/saveRole")
    public ApiResponse<Integer> saveRole(Role role) {
        return ApiResponse.success(roleService.save(role)) ;
    }

    @ApiOperation("修改角色")
    @PostMapping("/updateRole")
    public ApiResponse<Integer> updateRole(Role role) {
        return ApiResponse.success(roleService.update(role));
    }

    @ApiOperation("删除角色")
    @GetMapping("/removeRole")
    public ApiResponse<Integer> removeRole(int id) {
        return ApiResponse.success(roleService.remove(id));
    }

}
