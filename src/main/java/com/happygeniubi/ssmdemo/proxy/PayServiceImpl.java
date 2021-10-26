package com.happygeniubi.ssmdemo.proxy;

public class PayServiceImpl implements PayService{

    @Override
    public String callback(String outTradeNo) {
        System.out.println("目标类 PayServiceImpl 回调 方法 callback");
        return outTradeNo;
    }

    @Override
    public int save(int userId, int productId) {
        System.out.println("目标类 PayServiceImpl 回调 方法 save");
        return productId;
    }
}
