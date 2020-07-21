package com.liuyong.simplems.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello, spring boot!";
    }
}
