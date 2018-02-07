package implTest;

import TestBase.BaseServiceTestWithTransation;
import com.gaofei.dto.SCDTO;
import com.gaofei.interf.SCService;
import com.gaofei.request.BaseRequest;
import com.gaofei.request.SCRequest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GaoQingming on 2018/2/6 0006.
 */
@Service
public class SCServiceTest extends BaseServiceTestWithTransation {
    @Autowired
    private SCService scService;
    @Test
    public void testSelectSCList() {
        SCRequest scRequest = new SCRequest();
        scRequest.addOrderBy("score", BaseRequest.Order.ASC);
        scRequest.setOrder("score");
        List<SCDTO> scdtoList = scService.selectSCList(scRequest);
        Assert.assertNotNull(scdtoList);
    }
}
