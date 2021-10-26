package com.happygeniubi.ssmdemo.aop;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// 横切关注点
@Component
public class TimeHandler {

    public void printBefore() {
        System.out.println("printBefore 日志 time= " + LocalDateTime.now());
    }

    public void printAfter() {
        System.out.println("printAfter 日志 time= " + LocalDateTime.now());
    }
}
