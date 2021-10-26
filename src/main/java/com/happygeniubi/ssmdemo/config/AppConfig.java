package com.happygeniubi.ssmdemo.config;

import com.happygeniubi.ssmdemo.domain.VideoOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // 使用@Bean注解, 表明这个bean交给Spring进行管理,如果没有指定名称,默认采用方法名(第一个字母小写)作为bean的名称
    // 也可以@Bean("name = ") 自定义名称
    // @Bean(initMethod = "", destroyMethod = "") initMethod bean初始化方法 destroyMethod bean销毁方法, 需要在bean里面定义
    @Bean
    public VideoOrder videoOrder() {
        return new VideoOrder();
    }
}
