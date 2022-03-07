package com.nowcoder.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class AlphaAspect {

    @Pointcut("execution(* com.nowcoder.community.service.*.*(..))")//第一个*表示所有返回值;第二个*表示所有类;第三个*表示所有方法;(..)所有参数
    public void pointcut() {

    }

    @Before("pointcut()")//切点之前
    public void before() {
        System.out.println("before");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("afterRetuning");
    }//返回以后

    @AfterThrowing("pointcut()")//抛出异常后
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    @Around("pointcut()")//连接的前后都要
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before");
        Object obj = joinPoint.proceed();//调用原始方法
        System.out.println("around after");
        return obj;
    }

}
