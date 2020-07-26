package com.liuyong.simplems;

import com.liuyong.simplems.system.api.UserController;
import com.liuyong.simplems.system.dao.RoleMapper;
import com.liuyong.simplems.system.service.RoleService;
import com.liuyong.simplems.system.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SimpleMsApplicationTests {
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Autowired
    RoleMapper roleMapper;

    @Test
    void contextLoads() {
        roleMapper.listRoleMenus();
        roleMapper.getRoleMenuById(1);
        List<String> roleNameList = new ArrayList<>(Arrays.asList("超级管理员", "管理员"));
//        List<Integer> roleIdList = roleService.getIdByNameBatch(roleNameList);
    }

}
