package com.liuyong.simplems.system.api;

import com.liuyong.simplems.system.ent.User;
import com.liuyong.simplems.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public List<User> listAll() {
        return userService.listAll();
    }

    @GetMapping("/create")
    public int createUser(User user) {
        return userService.createUser(user);
    }
}
