package com.happygeniubi.ssmdemo.handler;

import com.happygeniubi.ssmdemo.utils.JsonData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

// 标记这是一个异常处理器(返回Json串)
@RestControllerAdvice // 返回Json串
//@ControllerAdvice // 返回自定义页面
public class CustomExtHandler {

      // 返回Json串
    @ExceptionHandler(value = Exception.class)
    Object handlerException(Exception e, HttpServletRequest request) {
        return JsonData.buildError("服务端出问题了:"+e.getMessage());
    }

//    // 返回自定义页面
//    @ExceptionHandler(value = Exception.class)
//    Object handlerException(Exception e, HttpServletRequest request) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("error.html");
//        modelAndView.addObject("msg", e.getMessage());
//        return modelAndView;
//    }
}
