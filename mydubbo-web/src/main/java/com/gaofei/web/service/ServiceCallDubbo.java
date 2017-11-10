package com.gaofei.web.service;

import com.gaofei.interf.InterfTest;

/**
 * Created by GaoQingming on 2017/9/5 0005.
 * 这个类可以作为service调用dubbo服务的例子
 * 点外面的main方法就行了
 */
public class ServiceCallDubbo {

    private InterfTest interfTest;

    public InterfTest getInterfTest() {
        return interfTest;
    }

    public void setInterfTest(InterfTest interfTest) {
        this.interfTest = interfTest;
    }

    public void start() {
        System.out.println("start myController");
        String s = interfTest.sayHello();
        System.out.println("dubbo service : " + s);
        System.out.println("--------------------------");
    }
}
