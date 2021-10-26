package com.happygeniubi.ssmdemo.proxy;

public interface PayService {

    // 支付回调
    String callback(String outTradeNo);

    // 下单
    int save(int userId, int productId);
}
