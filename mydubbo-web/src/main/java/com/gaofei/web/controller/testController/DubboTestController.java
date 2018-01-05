package com.gaofei.web.controller.testController;

import com.gaofei.interf.RedisTest;
import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * Created by GaoQingming on 2018/1/5 0005.
 */
@Controller
@RequestMapping("dubbotest")
public class DubboTestController {
    @Autowired
    private RedisTest redisTest;
    Logger logger = LoggerFactory.getLogger(DubboTestController.class);

    @RequestMapping("overTimeGet")
    @ResponseBody
    public String overTime(@RequestParam(value = "key",required = false) String key) {
        Stopwatch sw=Stopwatch.createStarted();
        String result = redisTest.get(key);
        logger.warn("overTimeGet eclapsed : {}",sw.elapsed(TimeUnit.SECONDS));
        return result;
    }

    @RequestMapping("overTimeSet")
    @ResponseBody
    public String overTimeSet(@RequestParam(value = "key",required = false) String key) {
        Stopwatch sw=Stopwatch.createStarted();
        redisTest.set(key);
        logger.warn("overTimeSet eclapsed : {}",sw.elapsed(TimeUnit.SECONDS));
        return "success";
    }
}
