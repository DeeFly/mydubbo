package com.gaofei.web.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.PriorityOrdered;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by GaoQingming on 2017/11/9 0009.
 */
public class DefaultExceptionHandler implements HandlerExceptionResolver, PriorityOrdered {
    Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);
    public int getOrder() {
        return 0;
    }

    //X-Requested-With:XMLHttpRequest这种就是ajax请求
    //
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        logger.error("系统出错url:{},params:{},userHost:{}",request.getRequestURL(),request.getParameterMap(),request.getRemoteHost(),e);
        response.setHeader("exceptionHandler","addValue");
        response.setHeader("content-code","105");
        if(isAjax(request)) {
            ModelAndView modelAndView = new ModelAndView();
            /*  使用response返回    */
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()); //设置状态码
            response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
            response.setCharacterEncoding("UTF-8"); //避免乱码
            response.setHeader("Cache-Control", "no-cache, must-revalidate");
            try {
                response.getWriter().write("{\"status\":0,\"success\":false,\"msg\":\"" + e.getMessage() + "\"}");
            } catch (IOException ex) {
                logger.error("与客户端通讯异常:"+ ex.getMessage(), ex);
            }
            return modelAndView;
        } else {
            return new ModelAndView("500");
            //这里要加http://，否则会在当前请求下拼接，导致找不到
            //return new ModelAndView("redirect:" + "http://www.gaofei.com/dubboweb/login/error");
        }
    }

    private boolean isAjax(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        if("XMLHttpRequest".equals(requestType)){
            return true;
            //System.out.println("AJAX请求..");
        }else{
            return false;
            //System.out.println("非AJAX请求..");
            //此时requestType为null
        }
    }
}
