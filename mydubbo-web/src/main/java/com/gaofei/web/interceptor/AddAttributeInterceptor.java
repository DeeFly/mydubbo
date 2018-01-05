package com.gaofei.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by GaoQingming on 2017/11/13 0013.
 */
public class AddAttributeInterceptor implements HandlerInterceptor {
    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return true 表示继续执行接下来的handler和controller，如果false，则不往下执行，interceptor和controller都不执行了
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        httpServletRequest.setCharacterEncoding("UTF-8");
        httpServletRequest.setAttribute("preHandler","preHandlerTest");
        //下面两行有没有异常都生效
        httpServletResponse.setHeader("preHandle","preHandle");
        httpServletResponse.setHeader("content-code","100");
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //奇怪，为什么这里设置的不生效，有没有异常都无效
        httpServletResponse.addHeader("postHandle","postHandle");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //奇怪，下面这一样只在抛出异常时有效
        httpServletResponse.addHeader("afterCompletion","afterCompletion");
    }
}
