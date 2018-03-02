package implTest;

import TestBase.BaseServiceTestWithoutTransaction;
import com.gaofei.poi.PoiServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GaoQingming on 2018/3/1 0001.
 */
@Service
public class PoiServiceImplTest extends BaseServiceTestWithoutTransaction{

    @Autowired
    private PoiServiceImpl poiService;

    @Test
    public void testLoadPoi() {
        poiService.loadPoi();
    }
}
