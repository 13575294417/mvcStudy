package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopTest {

    @Pointcut("execution( * *..AopTestService.*(..))")
    public void pointCutExecution() {

    }

    @Before("pointCutExecution()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        // 获取目标方法的参数信息
        Object[] args = joinPoint.getArgs();
        // AOP代理类信息
        Object aThis = joinPoint.getThis();
        // 代理的目标对象
        Object target = joinPoint.getTarget();
        // 用的最多，通知的签名
        Signature signature = joinPoint.getSignature();
        // 打印代理的是哪一个方法
        System.out.println("代理的方法是 ： " + signature.getName());
        // AOP 代理的名字
        System.out.println("AOP 代理的名字 ： " + signature.getDeclaringTypeName());

        signature.getDeclaringType();//  AOP代理类的类（class）信息

        /*
           通过RequestContextHolder获取请求信息，如session 信息 ;
         *//*
        //  获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //  从requestAttributes中获取HttpServletRequest信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //  获取session信息
        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);

        System.out.println("请求 ： " + request + " ,  HttpSession : " + session);
        Enumeration<String> enumerations = request.getParameterNames();
        //        Map<String,String> parameterMaps=new HashMap<>();
        Map<String, String> parameterMaps = Maps.newHashMap();
        while (enumerations.hasMoreElements()) {
            String parameter = enumerations.nextElement();
            parameterMaps.put(parameter, request.getParameter(parameter));
        }

        //        String str=JSON.toJSONString(parameterMaps);
        String str = JSON.toJSONString(parameterMaps);//   alibaba.fastjson
        if (obj.length > 0) {
            System.out.println("请求参数信息为 ： " + str);
        }*/
    }
}
