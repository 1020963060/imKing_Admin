package com.imking.imking_admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello.do")
    public String hello() {
        System.out.println("这是测试");
        return "你好，springboot";
    }
}
