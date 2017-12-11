package com.gaofei.web.controller.testController;

import com.gaofei.interf.RedisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by GaoQingming on 2017/12/8 0008.
 */
@Controller
@RequestMapping("testRedis")
public class RedisTestController {
    @Autowired
    private RedisTest redisTest;

    @RequestMapping("testString")
    public String testString(@RequestParam("toSave")String toSave) {
        redisTest.set(toSave);
        return "index";
    }

}
