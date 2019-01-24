package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    void addUser(User user, Integer flag);

    void batchAddUsers();
}
