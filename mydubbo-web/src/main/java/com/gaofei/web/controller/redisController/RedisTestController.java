package com.gaofei.web.controller.redisController;

import com.gaofei.interf.RedisTest;
import com.gaofei.redis.RedisBroadCastSendService;
import org.apache.commons.lang.StringUtils;
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
    @Autowired
    private RedisBroadCastSendService redisBroadCastSendService;

    @RequestMapping("testString")
    public String testString(@RequestParam(value = "toSave",required = false)String toSave) {
        if (StringUtils.isBlank(toSave)) {
            toSave = "defaultValue";
        }
        redisTest.set(toSave);
        return "index";
    }

    @RequestMapping("broadCast")
    public String broadCast(@RequestParam(value = "key",required = false) String key) {
        if (redisBroadCastSendService.sendMessage()) {
            return "index";
        }
        return "500";
    }

}
