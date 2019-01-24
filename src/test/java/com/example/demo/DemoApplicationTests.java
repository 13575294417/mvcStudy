package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        User user = new User();
        user.setAge(11);
        user.setName("如果感到快乐你就拍拍手");
        userService.addUser(user,0);
    }

    @Test
    public void test2() {
        userService.batchAddUsers();
    }

}
