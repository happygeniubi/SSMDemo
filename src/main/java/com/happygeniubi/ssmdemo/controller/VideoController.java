package com.happygeniubi.ssmdemo.controller;

import com.happygeniubi.ssmdemo.domain.Video;
import com.happygeniubi.ssmdemo.service.VideoService;
import com.happygeniubi.ssmdemo.utils.JsonData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

//    @RequestMapping(value = "list", method = RequestMethod.GET)
    @GetMapping("list")
    public Object list() {
        return JsonData.buildSuccess(videoService.videoList());
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideoChapter(@RequestBody Video video) {
        return JsonData.buildSuccess("");
    }
}
