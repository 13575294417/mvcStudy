package com.example.demo.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface TestAnnotation {

    @AliasFor("stupidDick")
    String value() default "";

    @AliasFor("value")
    String stupidDick() default "";

    Class[] shutUp() default {};
}
