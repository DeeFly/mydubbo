package TestBase;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Created by GaoQingming on 2017/10/27 0027.
 */
@ContextConfiguration("classpath*:META-INF/spring/service-test.xml")
public class BaseServiceTestWithoutTransaction extends AbstractJUnit4SpringContextTests {
    public BaseServiceTestWithoutTransaction() {
        //设置一些属性
        System.setProperty("superdiamond.projcode", "member");
    }
}
