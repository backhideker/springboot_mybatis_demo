package com.spring.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jie.a.xie on 8/27/2020.
 * MVC:(Model+View+Controller)(数据模型+视图+控制器）
 * 三层架构：(Presentation tier+Application tier+Date tier)(展现层+应用层+数据访问层）
 * mvc只是三层架构的展现层，mvc中的M是数据模型，是包含数据的对象，通常我们使用Spring MVC的时候有一个包叫Model,
 * 里面放的类就是用来和V交互的，V就是视图界面，包括jsp,html,freemarker,velocity,thymeleaf等，C就是控制器了（通常用@Controller注解的类）
 */
public class TestInterceptor implements HandlerInterceptor {
    int i=0;
    //目标方法执行前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user=request.getSession().getAttribute("loginUser");
        if(user==null){

        }
        System.out.println(i++);
        return true;
    }//在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制、权限校验等处理；

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post");
    }//在业务处理器处理请求执行完成后，生成视图之前执行。后处理（调用了Service并返回

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after");
    }//：在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。返回处理（已经渲染了页面）；
}
