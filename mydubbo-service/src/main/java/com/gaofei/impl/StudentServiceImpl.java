package com.gaofei.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gaofei.dto.StudentDTO;
import com.gaofei.exception.MydubboException;
import com.gaofei.interf.StudentService;
import com.gaofei.persist.dao.StudentMapper;
import com.gaofei.persist.domain.StudentDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by GaoQingming on 2017/11/9 0009.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    private  final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    public int updateStudent(int id, int age, int fail) throws Exception {
        int i = studentMapper.updateStudent(id,age);
        System.out.println("after mapper update : " + i);
        if(fail == 1) {
            //这里必须抛出运行时异常事务才会回滚
            throw new RuntimeException("fail");
        }
        //测试更新多条时候的返回值，更新n条，返回n
        //int j = studentMapper.updateStudentBySex(1,22);
        //System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj:" + j);
        return i;
    }

    public int insertStudent(StudentDTO studentDTO) {
        StudentDomain studentDomain = new StudentDomain();
        BeanUtils.copyProperties(studentDTO,studentDomain);
        int i = studentMapper.insertStudent(studentDomain);
        if (studentDTO.getAge() == 33) {
            throw new MydubboException("运行时异常，看有没有回滚");
        }
        logger.info("返回主键:{}",studentDomain.getStudentId());
        return studentDomain.getStudentId();
    }

    public StudentDTO getStudentById(int id) {
        StudentDomain studentDomain = studentMapper.getStudentById(id);
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(studentDomain,studentDTO);
        return studentDTO;
    }

    public String sayHello() {
        return "dubboTest gaofei haha";
    }

    public List<StudentDTO> selectStudents() {
        List<StudentDomain> studentDomains = studentMapper.selectStudents();
        List<StudentDTO> studentDTOList = new LinkedList<StudentDTO>();
        com.gaofei.utils.BeanUtils.copyListBeans(studentDomains,studentDTOList,StudentDomain.class,StudentDTO.class);
        return studentDTOList;
    }

    @Transactional
    public int testAdStudent(StudentDTO studentDTO) {
        StudentDomain studentDomain = new StudentDomain();
        BeanUtils.copyProperties(studentDTO,studentDomain);
        int i = studentMapper.insertStudent(studentDomain);
        if (studentDTO.getAge() == 55) {
            throw new MydubboException("运行时异常，看有没有回滚");
        }
        logger.info("返回主键:{}",studentDomain.getStudentId());
        return studentDomain.getStudentId();
    }
}
