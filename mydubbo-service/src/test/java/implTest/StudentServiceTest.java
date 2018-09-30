package implTest;

import TestBase.DubboTestBase;
import com.gaofei.dto.StudentDTO;
import com.gaofei.interf.StudentService;
import org.junit.Test;

/**
 * Created by GaoQingming on 2018/9/30 0030.
 */
public class StudentServiceTest extends DubboTestBase {
    StudentService studentService = (StudentService)context.getBean("studentService");
    @Test
    public void testInsertStudent() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(35);
        studentDTO.setStudentName("name");
        studentDTO.setAge(11);
        studentDTO.setGender(1);
        studentService.insertStudent(studentDTO);
    }


}
