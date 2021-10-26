package com.happygeniubi.ssmdemo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 应用上下文监听器
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("应用上下文监听器初始化... contextInitialized ======");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("应用上下文监听器销毁... contextDestroyed ======");

    }
}
