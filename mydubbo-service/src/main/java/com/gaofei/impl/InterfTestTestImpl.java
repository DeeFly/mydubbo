package com.gaofei.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gaofei.dto.StudentDTO;
import com.gaofei.interf.InterfTest;
import com.gaofei.persist.dao.StudentMapper;
import com.gaofei.persist.domain.StudentDomain;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by GaoQingming on 2017/9/5 0005.
 */
@Service
public class InterfTestTestImpl implements InterfTest {
    @Autowired
    private StudentMapper studentMapper;

    public int updateStudent(int id, int age, int fail) throws Exception {
        //RpcContext.getContext().getAttachments();
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

    public StudentDTO getStudentById(int id) {
        StudentDomain studentDomain = studentMapper.getStudentById(id);
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(studentDomain,studentDTO);
        return studentDTO;
    }

    public String sayHello() {
        return "dubboTest gaofei haha";
    }
}
