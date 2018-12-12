package com.example.demo.exception;

import com.example.demo.DemoApplication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//首先会在Controller类中查找有没@ExceptionHandler，没有找@RestControllerAdvice
//basePackages：只选择指定包和其子包下的controller
//basePackageClasses：该类所在的包和其子包下的controller
//assignableTypes：继承或者实现指定类型的controller
//annotations：含有指定类注解的controller
@RestControllerAdvice(basePackageClasses = DemoApplication.class)
public class ExceptionHandlerAdvice {

    //注解上没有指定捕获异常类型， 则根据方法上的参数类型进行捕获
    @ExceptionHandler
    public String handlerAllException(Exception e) {
        return e.getMessage();
    }
}
