package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("demo")
public class MvcTestController {

    @GetMapping("/show1")
    public String show1(HttpServletRequest request, HttpServletResponse response) {
        return "哈哈  你懂的";
    }

    @GetMapping("/show2/{id}")
    public String show2(@PathVariable("id") Long id) {
        return "占位符映射，id：" + id;
    }

    @GetMapping(value = "/show3", params = {"id", "name"})  //不管@RequestParam用不用，请求必须包含id/name参数，不然400错误
    public String show3(@RequestParam("id") String id) {
        return "id:"+id;
    }


    //不能和@ResponseBody混合使用
    /*@GetMapping("/show4")
    public String show4() {
        return "redirect:/show1";    //后面必须跟上URL路径而非视图名
    }

    @GetMapping("/show5")
    public String show5() {
        return "forward:/show1";
    }*/

    @GetMapping(value = "/show6")
    @ResponseStatus(HttpStatus.OK)
    public void show6() {
        int x = 1/0;
        System.out.println("哈哈");
    }

}
