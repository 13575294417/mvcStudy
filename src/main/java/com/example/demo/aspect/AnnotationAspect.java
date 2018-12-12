package com.example.demo.aspect;

import com.example.demo.annotation.TestAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationAspect {

    @Pointcut(value = "execution(* *..*.*(..)) && @annotation(com.example.demo.annotation.TestAnnotation)")
    public void annotationPointcutTest() {
    }

    @Before("annotationPointcutTest()")
    public void before(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "处理器：处理之前");

        TestAnnotation annotation = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(TestAnnotation.class);
        System.out.println("注解属性stupidDick：" + annotation.stupidDick());
        System.out.println("注解属性shutUp：");
        Class[] classes = annotation.shutUp();
        for (int i = 0; i < classes.length; i++) {
            Class aClass = classes[i];
            System.out.println(aClass.getName());
        }
        System.out.println();
    }

    @AfterReturning(returning="haha", pointcut="annotationPointcutTest()")
    public void logAnnotation(JoinPoint joinPoint,String haha) {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "处理器：处理之后");
        System.out.println("返回的modelAndView:" + haha);
        System.out.println();
    }

}
