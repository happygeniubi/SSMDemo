package com.happygeniubi.ssmdemo;

import com.happygeniubi.ssmdemo.domain.Video;
import com.happygeniubi.ssmdemo.service.VideoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        VideoService videoService = (VideoService) context.getBean("videoService");
        videoService.save(new Video());
        videoService.findById(33);
    }
}
