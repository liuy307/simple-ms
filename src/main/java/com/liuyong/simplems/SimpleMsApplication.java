package com.liuyong.simplems;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liuyong.simplems.system.dao")
public class SimpleMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleMsApplication.class, args);
    }

}
