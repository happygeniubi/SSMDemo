package com.happygeniubi.ssmdemo.proxy;

public class StaticProxyPayServiceImpl implements PayService{

    private PayService payService;

    public StaticProxyPayServiceImpl(PayService payService) {
        this.payService = payService;
    }

    @Override
    public String callback(String outTradeNo) {
        System.out.println("StaticProxyPayServiceImpl 静态代理打印日志(callback)");
        String result = payService.callback(outTradeNo);
        return result;
    }

    @Override
    public int save(int userId, int productId) {
        System.out.println("StaticProxyPayServiceImpl 静态代理打印日志(save)");
        int save = payService.save(userId, productId);
        return save;
    }
}
