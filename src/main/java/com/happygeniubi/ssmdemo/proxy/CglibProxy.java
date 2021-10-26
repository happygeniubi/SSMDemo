package com.happygeniubi.ssmdemo.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    // 目标类
    private Object targetObject;

    public Object newProxyInstance(Object targetObject) {
        this.targetObject = targetObject;

        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类（目标类）
        enhancer.setSuperclass(this.targetObject.getClass());
        enhancer.setCallback(this);
        // 创建子类（代理对象）
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        Object result = null;
        try {
            System.out.println("通过Cglib动态代理调用" + method.getName() +", 打印日志 begin");
            result = methodProxy.invokeSuper(o, objects);
            System.out.println("通过Cglib动态代理调用" + method.getName() +", 打印日志 end");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
