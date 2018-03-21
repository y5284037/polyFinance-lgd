package com.ptteng.polyFinance.lgd.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Arike
 * @program: polyFinance-lgd
 * @description: 后台拦截器.
 * @create: 2018/3/20 15:07
 */

public class AdminLoginInterceptor implements HandlerInterceptor{
    
    /**
     *
     * @param httpServletRequest 拉取请求
     * @param httpServletResponse 给予相应
     * @param o
     * @return true放行,false拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    
    }
    
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    
    }
}
