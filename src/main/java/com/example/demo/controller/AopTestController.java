package com.example.demo.controller;

import com.example.demo.service.AopTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://www.cnblogs.com/zdj-/p/8665454.html
 */
@RestController
@RequestMapping("aop")
public class AopTestController {

    @Autowired
    private AopTestService aopTestService;

    @GetMapping("add")
    public String add() {
        aopTestService.add();
        return "add";
    }

    @GetMapping("delete")
    public String delete() {
        aopTestService.delete();
        return "delete";
    }

    @GetMapping("get")
    public String get() {
        aopTestService.get();
        return "get";
    }

    @GetMapping("update")
    public String update() {
        aopTestService.update();
        return "update";
    }
}
