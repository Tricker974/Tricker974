package com.lator.tricker.mylator.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor{
    /***
     *  未登录需先登录
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取登录状态，判断是否已登录
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser==null){
            request.setAttribute("msg","未登录，请先登录");
            //前往登录页
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }else{
            return true;
        }

    }
}
