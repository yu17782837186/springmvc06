package com.ning.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoInterceptor implements HandlerInterceptor{
    //在进入控制器之前执行 如果返回值为false,阻止进入控制器
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("o"+o);
        System.out.println("preHandle");
        return false;
    }
    //控制器执行完成，进入到Jsp之前执行
    //在日志记录
    //敏感词语过滤
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("往"+modelAndView.getViewName()+"跳转");
        System.out.println("model的值"+modelAndView.getModel().get("model"));
        String word = modelAndView.getModel().get("model").toString();
        String newWord = word.replace("学习", "**");
        modelAndView.getModel().put("model",newWord);
//        modelAndView.getModel().put("model","修改后的值");
        System.out.println("postHandle");
    }
    //jsp执行完成后执行
    //记录执行过程中出现的异常
    //可以把异常记录到日志中
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion"+e.getMessage());
    }
}
