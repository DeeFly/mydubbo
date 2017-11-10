package com.gaofei.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GaoQingming on 2017/9/6 0006.
 */
@Controller
@RequestMapping("velocity")
public class VelocityController {

    @RequestMapping("index")
    public String testVelocity(ModelMap map) {
        map.addAttribute("test","testValue");
        List<String> list = new ArrayList<String>();
        list.add("String1");
        list.add("String2");
        list.add("String3");
        list.add("String4");
        map.addAttribute("list",list);
        return "index";
    }

    @RequestMapping("normaltest")
    public String normaltest() {
        return "layouttest/normaltest";
    }

    @RequestMapping("specialtest")
    public String specialtest() {
        return "layouttest/specialtest";
    }
}
