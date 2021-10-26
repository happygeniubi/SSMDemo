package com.happygeniubi.ssmdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 *   `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
 *   `out_trade_no` varchar(64) DEFAULT NULL COMMENT '订单唯一标识',
 *   `state` int(11) DEFAULT NULL COMMENT '0表示未支付，1表示已支付',
 *   `create_time` datetime DEFAULT NULL COMMENT '订单生成时间',
 *   `total_fee` int(11) DEFAULT NULL COMMENT '支付金额，单位分',
 *   `video_id` int(11) DEFAULT NULL COMMENT '视频主键',
 *   `video_title` varchar(256) DEFAULT NULL COMMENT '视频标题',
 *   `video_img` varchar(256) DEFAULT NULL COMMENT '视频图片',
 *   `user_id` int(12) DEFAULT NULL COMMENT '用户id',
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoOrder {
    private int id;
    private String outTradeNo;
    private int state;
    private LocalDateTime createTime;
    private int totalFee;
    private int videoId;
    private String videoTitle;
    private String videoImg;
    private int userId;
    private User user;
}
