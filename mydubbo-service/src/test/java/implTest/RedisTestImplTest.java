package implTest;

import TestBase.BaseServiceTestWithoutTransaction;
import com.gaofei.interf.RedisTest;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by GaoQingming on 2017/12/11 0011.
 */
@Service
public class RedisTestImplTest extends BaseServiceTestWithoutTransaction {
    @Autowired
    private RedisTest redisTest;

    @Test
    public void testSet() {
        redisTest.set("gaofei");
    }

    @Test
    public void testGet() {
        String value = redisTest.get("test");
        Assert.assertEquals("should be same","gaofei",value);
    }

    @Test
    public void testAdd() {
        Long result = redisTest.add(10);
        Assert.assertEquals(12L,result.longValue());
        HashMap map = new HashMap();
    }

    @Test
    public void testHashTest() {
        redisTest.hashTest();
    }
}
