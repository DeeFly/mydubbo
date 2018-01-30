package com.gaofei.web.constant;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by GaoQingming on 2017/8/15 0015.
 */
@Component
public class UrlConstant implements InitializingBean {
    private String serviceUrl;
    private String stringValue;
    private TestPostConstruct testPostConstruct;
    private String jdbcUrl;
    @Value("${annotation.value.test}")
    private String valueTest;
    //数据类型可以正常转化
    @Value("${numberTest}")
    private float number;

    public TestPostConstruct getTestPostConstruct() {
        return testPostConstruct;
    }

    public void setTestPostConstruct(TestPostConstruct testPostConstruct) {
        this.testPostConstruct = testPostConstruct;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getValueTest() {
        return valueTest;
    }

    public void setValueTest(String valueTest) {
        this.valueTest = valueTest;
    }

    public  String getJdbcUrl() {
        return jdbcUrl;
    }

    public  void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public  String getServiceUrl() {
        return serviceUrl;
    }

    public  void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("UrlConstant:@Value float converter test:" + this.number);
    }
}
