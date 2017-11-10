package com.gaofei.web.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by GaoQingming on 2017/11/10 0010.
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @RequestMapping("error")
    public String error() {
        return "500";
    }
}
