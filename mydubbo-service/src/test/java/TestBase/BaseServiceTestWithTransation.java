package TestBase;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by GaoQingming on 2017/10/27 0027.
 */
@ContextConfiguration(locations = {"classpath*:META-INF/spring/service-test.xml"})
//下面这行不加也会回滚，做update操作时，验证后回滚
@Transactional(value = "transactionManager")
public class BaseServiceTestWithTransation extends AbstractTransactionalJUnit4SpringContextTests {
    public BaseServiceTestWithTransation() {
        System.setProperty("superdiamond.projcode", "member");
        System.setProperty("superdiamond.profile", "development");
        System.setProperty("superdiamond.host", "192.168.30.86");
        System.setProperty("superdiamond.port", "38283");
    }
}
