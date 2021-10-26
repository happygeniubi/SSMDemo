package com.happygeniubi.ssmdemo.controller;

import com.happygeniubi.ssmdemo.task.AsyncTask;
import com.happygeniubi.ssmdemo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("api/v1/test")
@PropertySource("classpath:pay.properties")
public class TestController {

    @Value("${wxpay.appid}")
    private String payAppid;
    @Value("${wxpay.sercret}")
    private String parSecret;

    @Autowired
    private AsyncTask asyncTask;

    @GetMapping("async")
    public JsonData testAsync() throws ExecutionException, InterruptedException {
        long begin = System.currentTimeMillis();
//        asyncTask.taskOne();
//        asyncTask.taskTwo();
//        asyncTask.taskThree();
        Future<String> task4 = asyncTask.task4();
        Future<String> task5 = asyncTask.task5();
        String task4String = task4.get();
        String task5String = task5.get();
        long end = System.currentTimeMillis();
        return JsonData.buildSuccess(end - begin);
    }

    @GetMapping("list")
    public JsonData testExt() {
        int i = 1 / 0;
        return JsonData.buildSuccess("");
    }

    @GetMapping("get_config")
    public JsonData getConfig() {
        Map<String, String> map = new HashMap<>();
        map.put("payAppid",payAppid);
        map.put("String",parSecret);
        System.out.println("payAppid" + payAppid);
        System.out.println("parSecret" + parSecret);
        return JsonData.buildSuccess(map);
    }
}
