package com.liyujie.utils;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class Interceptor implements HandlerInterceptor {

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return 为true 执行下一个拦截器
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        //放行判断
        if(session.getAttribute("userLoginInfo")!=null)
            return true;
        if(request.getRequestURI().contains("Login"))
            return true;
        //跳转
        if(request.getRequestURI().contains("Doctor"))
            request.getRequestDispatcher("/WEB-INF/jsp/Doctor/Login.jsp").forward(request,response);
        else if(request.getRequestURI().contains("Patient"))
            request.getRequestDispatcher("/WEB-INF/jsp/Patient/Login.jsp").forward(request,response);
        else if(request.getRequestURI().contains("Admin"))
            request.getRequestDispatcher("/WEB-INF/jsp/Admin/Login.jsp").forward(request,response);
        return false;
    }


    /**
     * 用来加拦截日志
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("处理中");
    }


    /**
     * 用来加拦截日志
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("处理后");
    }
}
