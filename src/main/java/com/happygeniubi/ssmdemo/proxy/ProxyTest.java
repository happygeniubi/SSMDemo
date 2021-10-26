package com.happygeniubi.ssmdemo.proxy;

public class ProxyTest {

    public static void main(String[] args) {
//        PayService payService = new PayServiceImpl();
//        payService.callback("HappygeNiubi");

        // 静态代理
//        PayService payService = new StaticProxyPayServiceImpl(new PayServiceImpl());
//        payService.callback("HappygeNiubi");

        // JDK动态代理
//        JdkProxy jdkProxy = new JdkProxy();
        // 获取代理类对象
//        PayService payService = (PayService) jdkProxy.newProxyInstance(new PayServiceImpl());
        // 调用目标方法
//        payService.callback("JDK动态代理");

        // CgLib动态代理
        CglibProxy cglibProxy = new CglibProxy();
        PayService payService = (PayService) cglibProxy.newProxyInstance(new PayServiceImpl());
        // 调用目标方法
        payService.callback("Cglib动态代理");
    }
}
