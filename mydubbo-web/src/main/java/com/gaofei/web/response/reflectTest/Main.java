package com.gaofei.web.response.reflectTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GaoQingming on 2017/11/16 0016.
 */
public class Main {
    public static void main(String[] args) {
        List<Wrapper1> wrapper1s = new ArrayList();
        List<Wrapper2> wrapper2s = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Wrapper1 w = new Wrapper1();
            w.setDiff1("diff1:" + i);
            wrapper1s.add(w);
        }

        for (Wrapper1 wrapper1 : wrapper1s) {
            setSame(wrapper1,"getDiff1","setSame");
        }
        for (Wrapper1 wrapper1 : wrapper1s) {
            System.out.println(wrapper1.toString());
        }

        System.out.println("---------------------------------------");


        for (int i = 0; i < 10; i++) {
            Wrapper2 w = new Wrapper2();
            w.setDiff2("diff2:" + i);
            wrapper2s.add(w);
        }

        for (Wrapper2 wrapper2 : wrapper2s) {
            setSame(wrapper2,"getDiff2","setSame");
        }
        for (Wrapper2 wrapper2 : wrapper2s) {
            System.out.println(wrapper2.toString());
        }
    }
    public static void setSame(Object target,String diffMethod,String sameMethod) {
        try {
            Method diffM= target.getClass().getDeclaredMethod(diffMethod);
            Method sameM = target.getClass().getDeclaredMethod(sameMethod,String.class);
            try {
                String diffValue = (String)diffM.invoke(target);
                sameM.invoke(target,diffValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
