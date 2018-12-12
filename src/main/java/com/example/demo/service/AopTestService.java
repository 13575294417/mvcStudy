package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AopTestService {

    public void add() {
        System.out.println("添加商品业务");
    }

    public void delete() {
        System.out.println("删除商品业务");
    }

    public void get() {
        System.out.println("获取商品业务");
    }

    public void update() {
        System.out.println("修改商品业务");
    }
}
