package com.happygeniubi.ssmdemo.service;

import com.happygeniubi.ssmdemo.domain.Video;

import java.util.List;

public interface VideoService {

    List<Video> videoList();

    int save(Video video);

    Video findById(int id);
}
