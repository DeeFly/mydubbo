package com.gaofei.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GaoQingming on 2017/8/15 0015.
 */
@Service
public class TempService {
    @Autowired
    private ForInject forInject11;
    public int getNum() {
        System.out.println("forInject getMax:" + forInject11.getMax());
        return 0;
    }

    public ForInject getForInject() {
        return forInject11;
    }

    public void setForInject(ForInject forInject) {
        this.forInject11 = forInject;
    }
}
