package com.gaofei.web.controller;

import com.gaofei.interf.InterfTest;
import com.gaofei.web.constant.MyProperties;
import com.gaofei.web.constant.TestPostConstruct;
import com.gaofei.web.constant.UrlConstant;
import com.gaofei.web.request.StudentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by GaoQingming on 2017/8/15 0015.
 */
@Controller
@RequestMapping("controller")
public class MVCContrller {
    @Autowired
    private UrlConstant urlConstant;
    @Autowired
    private TestPostConstruct testPostConstruct;
    @Autowired
    private InterfTest interfTest;

    private final Logger logger = LoggerFactory.getLogger(MVCContrller.class);

    @RequestMapping("loginTest")
    public String login(HttpServletRequest request) {
        System.out.println("hahahhahahah");
        return "security/security";
    }

    @RequestMapping("handlerTest")
    @ResponseBody
    public String handlerTest(HttpServletRequest request) {
        String s = (String)request.getAttribute("preHandler");
        logger.trace(s);
        logger.info(s);
        logger.warn(s);
        logger.error(s);
        return s;
    }

    @RequestMapping("setTest")
    @ResponseBody
    public Set<String> setTest(HttpServletRequest request) {
        Set<String> set = new HashSet<>();
        set.add("111");
        set.add("222");
        return set;
    }

    @RequestMapping("third")
    public String testContrller() {
        String s = "loggerValue";
        System.out.println("third");
        System.out.println("jdbcUrl:" + urlConstant.getJdbcUrl());
        System.out.println("testPostConstruct in controller : " + testPostConstruct.getTestString());
        System.out.println("valueTest:" + urlConstant.getValueTest());
        logger.info("logger test :{} after value" , s);
        //String[] properties = MyProperties.getProperty("gaofei.test.properties").split(",");
        //List<String> p = Arrays.asList(properties);
        //for (String ps : p) {
        //    System.out.println(ps);
        //}
        System.out.println("properties Test : " + MyProperties.getProperty("gaofei.test.properties"));
        System.out.println("dubbo service : " + interfTest.sayHello());
        int i = 1/0;
        return "index";
    }

    /**
     * RequestBody test
     * 传值方式：post，
     * body中写如下数据:[{"name":"1234"},{"name":"sdfsdg"}]
     * Content-Type为application/json
     * @param students
     * @return
     */
    @RequestMapping(value = "requestBodyTest",method = RequestMethod.POST)
    public String insertStudent(@RequestBody StudentRequest[] students) {
        for (StudentRequest student : students) {
            logger.info("student:{}", student);
        }
        return "index";
    }

    //只接受ajax请求，还未验证 headers = { "X-Requested-With=XMLHttpRequest" }
    /*以下为判断是否ajax请求的方法，也没有验证
    String requestType = request.getHeader("X-Requested-With");
    if("XMLHttpRequest".equals(requestType)){
        System.out.println("AJAX请求..");
    }else{
        System.out.println("非AJAX请求..");
        //此时requestType为null
    }*/
    //@RequestMapping(value = "testParamsAndHeaders", params = { "username","age!=10" }, headers = { "X-Requested-With=XMLHttpRequest" })
    //public String testParamsAndHeaders() {
    //    System.out.println("testParamsAndHeaders");
    //    return SUCCESS;
    //}


}
