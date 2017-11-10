package com.gaofei.persist.dao;

import com.gaofei.persist.domain.StudentDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by GaoQingming on 2017/9/7 0007.
 */
public interface StudentMapper {
    StudentDomain getStudentById(int id);

    //update 可以返回值，更新一条的时候返回1，更新0条返回0
    int updateStudent(@Param("id") int id,@Param("age") int age);

    //更新多条的时候，返回相对应的更新数量。
    int updateStudentBySex(@Param("sex")int sex, @Param("age") int age);

    int insertStudent(@Param("stu") StudentDomain studentDomain);

    List<StudentDomain> selectStudents();
}
