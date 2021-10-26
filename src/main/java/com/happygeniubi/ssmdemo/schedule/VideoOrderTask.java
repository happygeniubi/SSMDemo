package com.happygeniubi.ssmdemo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 定时统计订单,金额
 */
@Component
public class VideoOrderTask {

    // 每两秒执行一次.
    @Scheduled(fixedRate = 2000) //2秒
    // 等任务结束之后再次调用.
//    @Scheduled(fixedDelay = 2000) //2+2(程序里面睡眠2秒)=4秒
//    @Scheduled(cron = "*/1 * * * * *")
    public void sum() {
        System.out.println(LocalDateTime.now() +
                "当前交易金额:" +
                Math.random());
        try {
            Thread.sleep(2000L);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}
