package com.happygeniubi.ssmdemo;

import com.happygeniubi.ssmdemo.domain.Video;
import com.happygeniubi.ssmdemo.service.VideoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 扫描指定的包,包括子包
        context.scan("com.happygeniubi.ssmdemo");
        // 里面完成初始化操作,核心方法
        context.refresh();

        VideoService videoService = (VideoService) context.getBean("videoService");
        Video video = (Video) context.getBean("Video");
        videoService.videoList();
        System.out.println(video);
        videoService.findById(9);

    }
}
