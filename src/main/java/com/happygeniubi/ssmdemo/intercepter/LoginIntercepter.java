package com.happygeniubi.ssmdemo.intercepter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.happygeniubi.ssmdemo.domain.User;
import com.happygeniubi.ssmdemo.service.impl.UserServiceImpl;
import com.happygeniubi.ssmdemo.utils.JsonData;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginIntercepter implements HandlerInterceptor {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginIntercepter -> preHandle...");

        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
        }
        if(StringUtils.isEmpty(token)) {
            System.out.println("请先登录...");
            JsonData jsonData = JsonData.buildError("请先登录...", 6001);
            String jsonStr = objectMapper.writeValueAsString(jsonData);
            renderJsonData(response, jsonStr);
            return false;
        }else {
            // 判断token是否合法
            User user = UserServiceImpl.tokenMap.get(token);
            if(user != null) {
//                return HandlerInterceptor.super.preHandle(request, response, handler);
                return true;
            }else {
                System.out.println("请先登录...");
                JsonData jsonData = JsonData.buildError("token无效,请重新登录...", 6002);
                String jsonStr = objectMapper.writeValueAsString(jsonData);
                renderJsonData(response, jsonStr);
                return false;
            }
        }
//        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginIntercepter -> postHandle...");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginIntercepter -> afterCompletion...");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
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
