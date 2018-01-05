package com.gaofei.web.controller.testController;

import com.gaofei.web.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by GaoQingming on 2018/1/4 0004.
 */
@RequestMapping("exception")
@Controller
public class ExceptonHandlerTestController {

    @RequestMapping("test")
    @ResponseBody
    public String test(@RequestParam(value = "wantException",required = false) String wantException) {
        if ("yes".equals(wantException)) {
            throw new MyException("exception  test!");
        }
        return "没有异常";
    }
}
