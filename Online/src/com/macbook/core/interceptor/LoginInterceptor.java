package com.macbook.core.interceptor;

import com.macbook.core.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author maweihong
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的url
        String url = request.getRequestURI();
        //URL:除登录请求、验证码请求、注册请求、修改密码外，其他URL都拦截控制
        if (url.indexOf("/getVerifyCode.action") >= 0){
            return true;
        }
        if(url.indexOf("/login.action") >= 0){
            return true;
        }
        if(url.indexOf("/toLogin.action") >= 0){
            return true;
        }
        if(url.indexOf("/toRegister.action") >= 0){
            return true;
        }
        if(url.indexOf("/register.action") >= 0){
            return true;
        }
        if(url.indexOf("/toChange.action") >= 0){
            return true;
        }
        
        //获取Session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        //判断session是否有用户数据，如果有，则返回true，否则返回false
        if(user != null){
            return true;
        }
        //不符合条件的给出提示，并转发到登录界面
        request.setAttribute("msg", "请先登录");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
