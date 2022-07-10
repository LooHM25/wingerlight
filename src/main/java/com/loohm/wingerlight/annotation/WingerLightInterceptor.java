package com.loohm.wingerlight.annotation;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WingerLightInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        WingerLight annotation;

        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(WingerLight.class);
        } else {
            return true;
        }

        if (annotation == null) {
            return true;
        }
        System.out.println("11111");
        System.out.println(annotation.value());
        return true;
    }
}
