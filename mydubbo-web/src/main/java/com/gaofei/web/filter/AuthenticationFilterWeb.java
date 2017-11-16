package com.gaofei.web.filter;

import com.sun.org.apache.bcel.internal.util.Objects;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by GaoQingming on 2017/11/14 0014.
 */
@Component
public class AuthenticationFilterWeb implements Filter ,ApplicationContextAware ,InitializingBean{
    @Autowired
    private RestTemplate restTemplate;
    private ApplicationContext applicationContext;
    //sso-client还需将当前会话id与令牌绑定，表示这个会话的登录状态与令牌相关，此关系可以用java的hashmap保存，保存的数据用来处理sso认证中心发来的注销请求
    private static Map<String,String> sessionMap = new HashMap();
    public void destroy() {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //先不用自定义的sessonContext了，看看springsecurity有没有好办法
        //HttpSession session = MySessionContext.getSession(request.getSession().getId());
        HttpSession session = request.getSession();
        if (Objects.equals(session.getAttribute("isLogin"),"yes")) {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        String token = request.getParameter("token");
        if (StringUtils.isNotBlank(token)) {
            String result = restTemplate.getForObject("http://127.0.0.1:8080/single/SSOServer/checkToken?token=" + token,String.class);
            if (Objects.equals(result,"yes")) {
                sessionMap.put(token,session.getId());
                session.setAttribute("isLogin","yes");
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }
        String from = request.getRequestURI();
        response.sendRedirect("http://127.0.0.1:8080/single/SSOServer/authentication?from=" + from);
    }

    //注入springContext中的bean用这种方式，本类不再springBeans的管理中。
    public void init(FilterConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(context);
        this.restTemplate = (RestTemplate) ac.getBean("restTemplate");
    }

    //！这个不行，注不进来
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //！applicationContext注不进来，那restTemplate等SpringContext中的bean通过这种方式是不能注入的
    public void afterPropertiesSet() throws Exception {
        this.restTemplate = (RestTemplate)applicationContext.getBean("restTemplate");
    }
}
