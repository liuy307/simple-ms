package com.liuyong.simplems.system.api;

import com.liuyong.simplems.common.base.BaseController;
import com.liuyong.simplems.common.core.model.ApiResponse;
import com.liuyong.simplems.system.ent.Menu;
import com.liuyong.simplems.system.ent.Permission;
import com.liuyong.simplems.system.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("permission")
@Api(tags = "权限管理接口")
public class PermissionController extends BaseController<Permission> {
}
