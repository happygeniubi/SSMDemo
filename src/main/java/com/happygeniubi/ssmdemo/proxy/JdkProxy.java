package com.happygeniubi.ssmdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

    private Object targetObject;

    // 获取代理对象
    public Object newProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        // 绑定关系，也就是和具体的哪个实现类关联
        return  Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;

        try {
            System.out.println("通过JDK动态代理调用" + method.getName() +", 打印日志 begin");
            result = method.invoke(targetObject, args);
            System.out.println("通过JDK动态代理调用" + method.getName() +", 打印日志 end");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
