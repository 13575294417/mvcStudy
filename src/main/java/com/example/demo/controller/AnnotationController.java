package com.example.demo.controller;

import com.example.demo.annotation.TestAnnotation;
import com.example.demo.entity.Dog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://blog.csdn.net/qq_33206732/article/details/78455942
 * https://blog.csdn.net/ln152315/article/details/78608438
 */
@RequestMapping("annotation")
@RestController
public class AnnotationController {

    @RequestMapping("show1")
    @TestAnnotation(stupidDick = "傻吊",shutUp = {Dog.class})
    public String show1() {
        System.out.println("执行业务流程1");
        System.out.println();
        return "show1的modelAndView";
    }

    @RequestMapping("show2")
    public String show2() {
        System.out.println("执行业务流程2");
        System.out.println();
        return "show2的modelAndView";
    }

    @RequestMapping("show3")
    @TestAnnotation
    public String show3() {
        System.out.println("执行业务流程3");
        System.out.println();
        return "show3的modelAndView";
    }
}
