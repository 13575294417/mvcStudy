package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("interceptor")
public class InterceptorController {

    @RequestMapping("/haha/show1")
    public void show1() {
        System.out.println("执行业务流程");
    }
}
