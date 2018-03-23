package com.ptteng.polyFinance.lgd.interceptor;

import com.ptteng.polyFinance.lgd.utils.JwtUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lujing
 * Create_at 2018/3/18 10:16
 */
public class LoginHomeInterceptor implements HandlerInterceptor {
    
    private static final Log log = LogFactory.getLog(LoginHomeInterceptor.class);
    
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
//        String url = request.getRequestURI();
//        String contextpath = request.getContextPath();
//
//        log.info("请求的url：" + url + "..." + contextpath);
//
//        Cookie cookie = WebUtils.getCookie(request, "tendk");
//        if (cookie == null) {
//            response.sendRedirect(request.getContextPath() + "/interceptor.html");
//            return true;
//
//        }
       
        return true;
        
        
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    
    }
    
    
}
