package com.gaofei.utils;

import com.alibaba.dubbo.common.utils.CollectionUtils;

import java.util.List;

/**
 * Created by GaoQingming on 2017/11/9 0009.
 */
public class BeanUtils {
    public static void copyListBeans(List sourceList,List targetList,Class sourceType,Class targetType) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return ;
        }
        try {
            for (Object source : sourceList) {
                Object o = targetType.newInstance();
                org.springframework.beans.BeanUtils.copyProperties(source,o);
                targetList.add(o);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
