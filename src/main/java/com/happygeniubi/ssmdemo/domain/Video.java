package com.happygeniubi.ssmdemo.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;

@Data
@Component("Video")
// 作用域(设置为多例,默认为单例, 多例:每次都新建一个对象, 单例:每次都复用同一个对象)
// @Scope("prototype")
public class Video implements Serializable {
//    private int id;
//    private String title;
//    @JsonInclude(JsonInclude.Include.NON_NULL) // 若字段为空则不返回. (默认返回null)
//    private String summary;
//    private int price;
//    @JsonProperty("cover_img") // 返回字段别名
//    private String coverImg;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime createTime;
//    private List<Chapter> chapterList;

    /**
     * 主键
     */
    private int id;

    /**
     * 视频标题
     */
    private String title;

    /**
     * 视频详情
     */
    private String summary;


    /**
     *视频封面图
     */
    private String coverImg;


    /**
     * 价格
     */
    private int price;


//    /**
//     * 创建时间
//     */
//    private LocalDateTime createTime;

    /**
     * 评分
     */
    private double point;


//    public Video(int id, String title, LocalDateTime createTime) {
//        this.id = id;
//        this.title = title;
//        this.createTime = createTime;
//    }

    @PostConstruct
    public void init() {
        System.out.println("video类 init 方法被调用");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("video类 destroy 方法被调用");
    }

    public Video() {

    }


}
