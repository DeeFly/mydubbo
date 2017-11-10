package com.gaofei.interf;

import com.gaofei.dto.StudentDTO;

/**
 * Created by GaoQingming on 2017/9/5 0005.
 */
public interface InterfTest {
    String sayHello();

    StudentDTO getStudentById(int id);

    int updateStudent(int id, int age, int fail) throws Exception;
}
