package com.happygeniubi.ssmdemo;

import com.happygeniubi.ssmdemo.domain.VideoOrder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigApplication {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 扫描指定的包,包括子包
        context.scan("com.happygeniubi.ssmdemo");
        // 里面完成初始化操作,核心方法
        context.refresh();

        VideoOrder videoOrder = (VideoOrder) context.getBean("videoOrder");
    }
}
