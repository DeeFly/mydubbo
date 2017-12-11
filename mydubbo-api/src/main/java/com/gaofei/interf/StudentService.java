package com.gaofei.interf;

import com.gaofei.dto.StudentDTO;

import java.util.List;

/**
 * Created by GaoQingming on 2017/11/9 0009.
 */
public interface StudentService {

    /**
     * 测试用
     * @return
     */
    String sayHello();

    /**
     * 通过id获取学生
     * @param id
     * @return
     */
    StudentDTO getStudentById(int id);

    /**
     * 根据id更新学生，通过fail进行事务测试
     * @param id
     * @param age
     * @param fail   1的时候测试事务回滚，别的值不回滚
     * @return
     * @throws Exception
     */
    int updateStudent(int id, int age, int fail) throws Exception;

    /**
     * 添加单个学生
     * @param studentDTO
     * @return
     */
    int insertStudent(StudentDTO studentDTO);

    List<StudentDTO> selectStudents();

    /**
     * 测试用注解的事务
     */
    int testAdStudent(StudentDTO studentDTO);
}
