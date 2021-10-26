package com.happygeniubi.ssmdemo.dao;

import com.happygeniubi.ssmdemo.domain.User;
import com.happygeniubi.ssmdemo.domain.VideoOrder;

import java.util.List;

public interface VideoOrderMapper {

    /**
     * 查询全部订单, 关联用户信息
     * @return
     */
    List<VideoOrder> queryVideoOrderList();

    /**
     * 查询全部用户，关联订单信息
     * @return
     */
    List<User> queryUserOrderList();

    /**
     * 查询全部订单, 关联用户信息（懒加载）
     * @return
     */
    List<VideoOrder> queryVideoOrderListLazy();
}
