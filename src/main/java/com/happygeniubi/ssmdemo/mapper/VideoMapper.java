package com.happygeniubi.ssmdemo.mapper;


import com.happygeniubi.ssmdemo.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VideoMapper {
    private static Map<Integer, Video> videoMap = new HashMap<>();

    static {
//        videoMap.put(1, new Video(1,"Spring cloud", LocalDateTime.now()));
//        videoMap.put(2, new Video(2,"Mybatis Plus", LocalDateTime.now()));
//        videoMap.put(3, new Video(3,"Swagger2", LocalDateTime.now()));
//        videoMap.put(4, new Video(4,"Hutool", LocalDateTime.now()));
//        videoMap.put(5, new Video(5,"XXL-JOB", LocalDateTime.now()));
    }

    public List<Video> videoList() {
        /**
            List<Video> videoList = new ArrayList<>();
            videoList.addAll(videoMap.values());
        */
        return new ArrayList<>(videoMap.values());
    }
}
