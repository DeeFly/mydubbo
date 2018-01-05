package com.gaofei.interf;

/**
 * Created by GaoQingming on 2017/12/8 0008.
 */
public interface RedisTest {
    void set(String key);
    String get(String key);

    Long add(int n);

    void hashTest();
}
