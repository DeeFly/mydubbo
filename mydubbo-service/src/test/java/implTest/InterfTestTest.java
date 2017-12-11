package implTest;

import TestBase.BaseServiceTestWithTransation;
import com.gaofei.dto.StudentDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GaoQingming on 2017/10/27 0027.
 */
@Service
public class InterfTestTest extends BaseServiceTestWithTransation{
    @Autowired
    private com.gaofei.interf.InterfTest interfTestImpl;
    @Test
    public void testSatHello() {
        Assert.assertNotNull(interfTestImpl.sayHello());
    }

    @Test
    public void testGetStudentById() {
        StudentDTO studentDTO = interfTestImpl.getStudentById(1);
        Assert.assertEquals("姓名应该相同","高飞",studentDTO.getStudentName());
    }

    //@Test(expected = RuntimeException.class)
    @Test
    public void testupdateStudent() {
        try {
            int i = interfTestImpl.updateStudent(1,16,2);
            Assert.assertEquals("=========",1,i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
