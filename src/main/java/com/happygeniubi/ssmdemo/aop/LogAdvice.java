package com.happygeniubi.ssmdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 标注为切面类
@Aspect
@Component
public class LogAdvice {

    // 切入点表达式
    @Pointcut("execution(* com.happygeniubi.ssmdemo.service.VideoService.*(..))")
    public void aspect() {

    }

    // 前置通知
//    @Before("aspect()")
    @Before("execution(* com.happygeniubi.ssmdemo.service.VideoService.*(..))")
    public void beforeLog(JoinPoint joinPoint) {
        System.out.println("LogAdvice beforeLog被调用");
    }

    // 后置通知
    @After("aspect()")
    public void afterLog(JoinPoint joinPoint) {
        System.out.println("LogAdvice afterLog被调用");
    }
}
