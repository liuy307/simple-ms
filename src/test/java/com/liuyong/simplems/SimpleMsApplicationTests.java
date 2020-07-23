package com.liuyong.simplems;

import com.liuyong.simplems.system.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimpleMsApplicationTests {
    @Autowired
    RoleService roleService;

    @Test
    void contextLoads() {
        roleService.list();
    }

}
