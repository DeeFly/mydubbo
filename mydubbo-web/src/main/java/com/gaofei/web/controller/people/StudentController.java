package com.gaofei.web.controller.people;

import com.gaofei.dto.StudentDTO;
import com.gaofei.interf.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by GaoQingming on 2017/11/9 0009.
 */
@Controller
@RequestMapping("student")
public class StudentController {
    Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;

    @RequestMapping("insertStudent")
    @ResponseBody
    public String insertStudent() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setAge(11);
        studentDTO.setGender(1);
        studentDTO.setStudentName("ceshi1");
        studentService.insertStudent(studentDTO);
        return "index";
    }

    @ResponseBody
    @RequestMapping("selectStudents")
    public List<StudentDTO> selectStudents() {
        List<StudentDTO> list =  studentService.selectStudents();
        return list;
    }

    @RequestMapping("test")
    public String test() {
        return "index";
    }
}
