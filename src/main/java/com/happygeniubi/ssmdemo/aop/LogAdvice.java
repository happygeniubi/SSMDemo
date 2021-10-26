package com.happygeniubi.ssmdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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


    /**
     * 环绕通知
     * @param joinPoint
     */
    @Around("aspect()")
    public void around(JoinPoint joinPoint){
        Object target = joinPoint.getTarget().getClass().getName();
        System.out.println("调⽤者="+target);
        //⽬标⽅法签名
        System.out.println("调⽤⽅法="+joinPoint.getSignature());
        //通过joinPoint获取参数
        Object [] args = joinPoint.getArgs();
        if(args.length>0) {
            System.out.println("参数=" + args[0]);
        }

        long start = System.currentTimeMillis();
        System.out.println("环绕通知 环绕前=========");

        //执⾏连接点的⽅法
        try {
            ((ProceedingJoinPoint)joinPoint).proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("环绕通知 环绕后=========");
        System.out.println("调⽤⽅法总耗时 time = " + (end - start) +" ms");
    }
}
