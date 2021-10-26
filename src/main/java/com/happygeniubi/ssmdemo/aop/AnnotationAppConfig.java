package com.happygeniubi.ssmdemo.aop;

import com.happygeniubi.ssmdemo.service.VideoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.happygeniubi.ssmdemo")
@EnableAspectJAutoProxy //开启了spring对aspect的⽀持
public class AnnotationAppConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationAppConfig.class);
        VideoService videoService = (VideoService) context.getBean("videoService");
        videoService.findById(2);
    }
}
