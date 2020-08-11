package com.liuyong.simplems;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuyong.simplems.common.service.CacheService;
import com.liuyong.simplems.common.service.RedisService;
import com.liuyong.simplems.exception.RedisConnectException;
import com.liuyong.simplems.system.dao.RoleMapper;
import com.liuyong.simplems.system.dao.UserMapper;
import com.liuyong.simplems.system.dao.UserRoleMapper;
import com.liuyong.simplems.system.dto.UserDTO;
import com.liuyong.simplems.system.ent.*;
import com.liuyong.simplems.system.manager.UserManager;
import com.liuyong.simplems.system.service.MenuService;
import com.liuyong.simplems.system.service.RoleService;
import com.liuyong.simplems.system.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Set;

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

    @Autowired
    RedisService redisService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

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

    @Autowired
    RoleMapper roleMapper;
    @Test
    void testRoleService() {
        List<Role> roles = roleMapper.getRolesByAccount("111");
        List<Role> roles2 = roleService.getRolesByAccount("111");
    }

    @Test
    void testUserManager() {
        String account = "111";
        User user = userManager.getUser(account);
        Set<String> roleNames = userManager.getRoleNameSet(account);
        Set<String> permissionNames = userManager.getPermissionNameSet(account);
        Set<String> menuNames = userManager.getMenuNameSet(account);
    }

    @Test
    void testRedis() throws RedisConnectException, JsonProcessingException {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setAccount("111");
        loginInfo.setPassword("111");

        String result = redisService.set("liu", objectMapper.writeValueAsString(loginInfo));
        String objString = redisService.get("liu");
        LoginInfo obj = objectMapper.readValue(objString, loginInfo.getClass());
    }

    @Test
    void testRedisTemple() {
        String result = redisTemplate.opsForValue().get("liu");
    }

    @Autowired
    CacheService cacheService;
    @Test
    void testCacheService() throws Exception {
        String account = "111";
        cacheService.saveUserByAccount(account);
        cacheService.saveRolesByAccount(account);
        cacheService.savePermissionsByAccount(account);

        User user = cacheService.getUserByAccount(account);
        List<Role> roles = cacheService.getRolesByAccount(account);
        List<Permission>permissions = cacheService.getPermissionsByAccount(account);
    }

    @Autowired
    UserManager userManager;
    @Test
    void testUserManage() throws RedisConnectException, JsonProcessingException {
        String account = "111";
        User user = userManager.getUser(account);

        cacheService.saveUserByAccount(account);
        User user2 = userManager.getUser(account);
    }


    @Test
    void testDTO() {
        UserDTO userDTO = new UserDTO();
//        UserDTO2 userDTO2 = new UserDTO2();
        userMapper.save(userDTO);
//        userMapper.save(userDTO2);
    }
}
