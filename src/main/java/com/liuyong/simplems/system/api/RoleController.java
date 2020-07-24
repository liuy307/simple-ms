package com.liuyong.simplems.system.api;

import com.liuyong.simplems.common.base.BaseController;
import com.liuyong.simplems.common.core.model.ApiResponse;
import com.liuyong.simplems.system.ent.Role;
import com.liuyong.simplems.system.ent.User;
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
public class RoleController extends BaseController<Role> {
    @Autowired
    RoleService roleService;

    @Override
    @ApiOperation("增加")
    @PostMapping("/save")
    public ApiResponse<Integer> save(Role role) {
        int i = roleService.save(role);
        return ApiResponse.success(role.getId());
    }
}
