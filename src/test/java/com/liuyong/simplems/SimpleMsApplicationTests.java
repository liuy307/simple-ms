package com.liuyong.simplems;

import com.liuyong.simplems.system.dao.RoleMapper;
import com.liuyong.simplems.system.dao.UserMapper;
import com.liuyong.simplems.system.dao.UserRoleMapper;
import com.liuyong.simplems.system.ent.LoginInfo;
import com.liuyong.simplems.system.ent.Menu;
import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.ent.UserRole;
import com.liuyong.simplems.system.service.MenuService;
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
    MenuService menuService;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        LoginInfo loginInfo = new LoginInfo();        loginInfo.setAccount("111");
        loginInfo.setPassword("111");
        List<User> users = userMapper.listUserRoleMenusPermissionsByLoginInfo(loginInfo);
        System.out.println(users);
    }

    @Test
    void testMenuService() {
//        List<Menu> allMenus = menuService.list();
//        List<Menu> levelMenus = new ArrayList<>();
//        for (int i = 0; i < allMenus.size(); i++) {
//            Menu currentMenu = allMenus.get(i);
//            if(currentMenu.getParentMenuId() == -1) {
//                menuService.RecursiveChild(currentMenu, allMenus);
//                levelMenus.add(currentMenu);
//            }
//        }

        List<Menu> allMenus = menuService.list();
    }

    @Test
    void testUserRoleMapper() {
        List<UserRole>userRoleList = userRoleMapper.list();
        userRoleMapper.saveBatch(userRoleList);
        userRoleMapper.removeByUserId(3);
    }

    @Test
    void testLogin() {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setAccount("111");
        loginInfo.setPassword("111");
        List<User> s = userService.listUserRoleMenusByLoginInfo(loginInfo);
        System.out.println(s);
    }
}
