package TestBase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by GaoQingming on 2018/9/30 0030.
 */
public class DubboTestBase {
    protected ClassPathXmlApplicationContext context;

    public DubboTestBase() {
        try {
            context = new ClassPathXmlApplicationContext(new String[]{"classpath:/spring/dubbo-demo-consumer.xml"});
            context.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
