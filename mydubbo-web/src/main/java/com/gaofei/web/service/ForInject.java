package com.gaofei.web.service;

import com.gaofei.web.aop.MyAnnotationTest;
import com.gaofei.web.constant.MyProperties;
import org.springframework.stereotype.Service;

/**
 * Created by GaoQingming on 2017/8/15 0015.
 */
@Service
public class ForInject extends MyProperties {
    @MyAnnotationTest
    public int getMax() {
        return 11;
    }
}
