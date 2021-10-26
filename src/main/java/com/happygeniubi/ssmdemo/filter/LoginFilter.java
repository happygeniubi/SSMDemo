package com.happygeniubi.ssmdemo.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.happygeniubi.ssmdemo.domain.User;
import com.happygeniubi.ssmdemo.service.impl.UserServiceImpl;
import com.happygeniubi.ssmdemo.utils.JsonData;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(urlPatterns = "/api/v1/pri/*", filterName = "LoginFilter")
public class LoginFilter implements Filter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 容器加载的时候
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init LoginFilter...");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter LoginFilter...");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String token = httpServletRequest.getHeader("token");
        if(StringUtils.isEmpty(token)) {
            token = httpServletRequest.getParameter("token");
        }
        if(StringUtils.isEmpty(token)) {
            System.out.println("请先登录...");
            JsonData jsonData = JsonData.buildError("请先登录...", 6001);
            String jsonStr = objectMapper.writeValueAsString(jsonData);
            renderJsonData(httpServletResponse, jsonStr);
        }else {
            // 判断token是否合法
            User user = UserServiceImpl.tokenMap.get(token);
            if(user != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                System.out.println("请先登录...");
                JsonData jsonData = JsonData.buildError("token无效,请重新登录...", 6002);
                String jsonStr = objectMapper.writeValueAsString(jsonData);
                renderJsonData(httpServletResponse, jsonStr);
            }
        }
    }

    /**
     * 容器销毁的时候
     */
    @Override
    public void destroy() {
        System.out.println("destroy LoginFilter...");
        Filter.super.destroy();
    }

    private void renderJsonData(HttpServletResponse response, String json) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try(PrintWriter writer = response.getWriter()) {
            writer.println(json);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
