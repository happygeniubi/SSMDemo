package com.happygeniubi.ssmdemo.service.impl;

import com.happygeniubi.ssmdemo.config.CustomConfig;
import com.happygeniubi.ssmdemo.domain.Video;
import com.happygeniubi.ssmdemo.mapper.VideoMapper;
import com.happygeniubi.ssmdemo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("videoService")
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private CustomConfig config;

    @Override
    public List<Video> videoList() {
        return videoMapper.videoList();

    }

    @Override
    public int save(Video video) {
        System.out.println("保存Video");
        return 1;
    }

    @Override
    public Video findById(int id) {
        System.out.println("根据Id找视频");
        System.out.println("findById获取配置文件Host:" + config.getHost());
        System.out.println("findById获取配置文件Port:" + config.getPort());
        return new Video();
    }
}
