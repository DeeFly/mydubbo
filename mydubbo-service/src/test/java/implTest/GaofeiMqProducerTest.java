package implTest;

import TestBase.BaseServiceTestWithoutTransaction;
import com.gaofei.dto.StudentDTO;
import com.gaofei.mq.GaofeiMqProducer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by GaoQingming on 2017/12/14 0014.
 */
@Service
public class GaofeiMqProducerTest extends BaseServiceTestWithoutTransaction{
    @Qualifier("gaofeiMqProducer")
    @Autowired
    private GaofeiMqProducer gaofeiMqProducer;
    @Test
    public void testSendDataToQueue() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("gaofei");
        studentDTO.setGender(1);
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gaofeiMqProducer.sendDataToQueue(studentDTO);
        }
    }
}
