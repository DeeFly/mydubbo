package com.gaofei.web.controller;

import com.gaofei.web.service.TempService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by GaoQingming on 2017/8/15 0015.
 */
public class LoginContrller extends HttpServlet{
    private TempService tempService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("second");
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        TempService tempService = (TempService)context.getBean("tempService");
        int i = tempService.getNum();
        System.out.println(i);
        //System.out.println("url:" + UrlConstant.serviceUrl);
        //System.out.println("jdbcurl:" + UrlConstant.jdbcUrl);
        req.getRequestDispatcher("/WEB-INF/jsp/second.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
