package com.example.demo.service.impl;

import com.example.demo.annotation.BatchProcessAnnotation;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user, Integer flag) {
        System.out.println("添加新的用户！");
    }

    @Override
    @BatchProcessAnnotation("你懂个求？")
    public void batchAddUsers() {
        System.out.println("批量添加用户");
    }

}