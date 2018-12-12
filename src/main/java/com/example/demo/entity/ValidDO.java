package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ValidDO implements Serializable {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "年龄不能为空")
    @Pattern(regexp="^[0-9]{1,2}$",message="年龄不正确")
    private String age;

    //@validate不能用在字段上
    //@valid用来级联对象中的属性验证
    //传参时如果dog = null，触发的是NotNull注解，Dog的属性验证不会被出发
    @Valid
    @NotNull(message = "必须有条狗")
    private Dog dog;
}
