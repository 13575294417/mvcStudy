package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/handler")
public class ExceptionHandlerController {

    @GetMapping("/show1")
    public String test1() {
        int x = 1/0;
        return "test1 正常展示";
    }
}
