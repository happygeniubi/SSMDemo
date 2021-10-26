package com.happygeniubi.ssmdemo;


import com.happygeniubi.ssmdemo.domain.Video;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        System.out.println("测试Main...");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Video video = (Video) applicationContext.getBean("video");
        System.out.println(video);
    }
}
