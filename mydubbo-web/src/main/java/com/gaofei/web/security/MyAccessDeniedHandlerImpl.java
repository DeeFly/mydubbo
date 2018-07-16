package com.gaofei.web.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by GaoQingming on 2018/4/24 0024.
 */
public class MyAccessDeniedHandlerImpl implements AccessDeniedHandler {


    public MyAccessDeniedHandlerImpl() {

    }

    //public String getAccessDeniedUrl() {
    //    return accessDeniedUrl;
    //}
    //
    //public MyAccessDeniedHandlerImpl(String accessDeniedUrl) {
    //    this.accessDeniedUrl = accessDeniedUrl;
    //}
    //
    //public void setAccessDeniedUrl(String accessDeniedUrl) {
    //    this.accessDeniedUrl = accessDeniedUrl;
    //}


    //private String accessDeniedUrl = XueleSSOClient.MEMBER_URL + "system/error?errorInfo=5oKo55qE5p2D6ZmQ5LiN6Laz";

    @Override
    public void handle(HttpServletRequest req,
                       HttpServletResponse resp, AccessDeniedException reason) throws ServletException,
            IOException {
        if (AjaxUtil.isAjax(req)) {
            AjaxUtil.outputAjaxException(req, resp, reason);
            return;
        } else {
            //resp.sendRedirect(XueleSSOClient.MEMBER_URL);
        }
    }

}