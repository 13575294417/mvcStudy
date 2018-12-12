# mvcStudy
spring-boot下对mvc部分功能进行总结，供以后复习

## aop切面类相关注解

> 自动开启代理注解，不需要额外设置 @EnableAspectJAutoProxy.
> 引入spring-boot-starter-aop包即可

* 类上 @Aspect @Component 两注解声明
* @Pointcut 中的 execution 表达式
* 切入点方法返回值 void，方法空实现
* 通知注解引入切入点表达式："切入点方法名()"
* 通知方法入参：(JoinPoint joinPoint)

```java
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
    // AOP代理类的类（class）信息
    signature.getDeclaringType();
}
```

参考：https://www.cnblogs.com/zdj-/p/8665454.html

## 自定义注解结合AspectJ

> spring-boot-starter-aop包中引用了spring-aop 和 aspectjweaver

* 创建注解类 @interface
* 切入点表达式后 && 拼接 @annotation，@annotation中是过滤的注解的全限定名
* 通过 JoinPoint拿到 MethodSignature，再拿方法对象和方法上的注解

```java
@Pointcut(value = "execution(* *..*.*(..)) && @annotation(com.example.demo.annotation.TestAnnotation)")
public void annotationPointcutTest() {
}
```

参考：https://blog.csdn.net/qq_33206732/article/details/78455942    
https://blog.csdn.net/ln152315/article/details/78608438


## 统一异常处理
> 只需要引入spring-boot-starter-web包

* 1.直接在 controller 类中加入 @ExceptionHandler 方法捕获异常
* 2.或者创建一个类，类上加@ControllerAdvice，通过basePackages、basePackageClasses、assignableTypes、annotations选择器选择符合条件的controller
* 创建异常处理方法，注解@ExceptionHandler标记
* 在注解中指定捕获异常的范围，否则查找异常处理方法上的参数类型，作为范围

参考：自己的简书

## HibernateValidate

> spring-boot-starter-web包中自动引入了hibernate-validator包，直接用

* DO中给字段添加相应注解。如：@NotNull，message填写提示信息
* 处理器入参添加@Validate注解，对象如果为null，不会触发对象属性验证
* 级联验证时，对象类型的属性上添加@Valid

```java
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
```

参考：http://www.cnblogs.com/mr-yang-localhost/p/7812038.html


## 自定义拦截器

> 正序前置拦截器(处理器执行之前) -> 逆序后置拦截器(处理器执行之后) -> 逆序最终拦截器(视图渲染之后)。
> 执行某个前置拦截器时，返回false，后置拦截器统统不执行，成功拦截器的最终拦截器逆序执行。

* 自定义拦截器实现HandlerInterceptor，添加@Component
* 配置类实现WebMvcConfigurer接口的addInterceptors方法， InterceptorRegistry添加拦截器、添加匹配路径
