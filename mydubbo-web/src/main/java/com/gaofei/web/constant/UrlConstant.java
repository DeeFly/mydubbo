package com.gaofei.web.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by GaoQingming on 2017/8/15 0015.
 */
@Component
public class UrlConstant {
    private String serviceUrl;
    private String jdbcUrl;
    @Value("${annotation.value.test}")
    private String valueTest;

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


}
