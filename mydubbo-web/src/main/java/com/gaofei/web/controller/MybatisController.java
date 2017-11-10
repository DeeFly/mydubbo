package com.gaofei.web.controller;

import com.gaofei.dto.StudentDTO;
import com.gaofei.interf.InterfTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by GaoQingming on 2017/9/7 0007.
 */
@RequestMapping("mybatis")
@Controller
public class MybatisController {
    @Autowired
    private InterfTest interfTest;

    @RequestMapping("getStudent")
    public String getStudent(int id) {
        StudentDTO studentDTO = interfTest.getStudentById(id);
        System.out.println(studentDTO.getStudentName());
        return "index";
    }

    @RequestMapping("transaction")
    public String transaction(int id, int age, int fail) {
        try {
            interfTest.updateStudent(id,age,fail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
}
