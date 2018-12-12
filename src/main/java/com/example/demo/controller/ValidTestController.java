package com.example.demo.controller;

import com.example.demo.entity.ValidDO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * http://www.cnblogs.com/mr-yang-localhost/p/7812038.html
 */
@RestController
@RequestMapping("valid")
public class ValidTestController {

    //类中有ExceptionHandler优先使用类中的，没有再去@ControllerAdvice中查找
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handlerValidException(MethodArgumentNotValidException e) {
        List<String> messages = new ArrayList<>();

        BindingResult result = e.getBindingResult();
        List<ObjectError> allErrors = result.getAllErrors();
        for (Iterator<ObjectError> iterator = allErrors.iterator(); iterator.hasNext(); ) {
            ObjectError error = iterator.next();
            messages.add(error.getDefaultMessage());
        }
        return messages;
    }

    //Validated是spring的，是对valid的一个变形
    //如果validDO = null，不会触发类中的属性验证
    @RequestMapping("show1")
    public ValidDO valid(@RequestBody @Validated ValidDO validDO) {
        return validDO;
    }
}
