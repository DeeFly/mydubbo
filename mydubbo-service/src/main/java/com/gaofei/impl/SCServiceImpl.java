package com.gaofei.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gaofei.dto.SCDTO;
import com.gaofei.interf.SCService;
import com.gaofei.persist.dao.SCMapper;
import com.gaofei.persist.domain.SCDomain;
import com.gaofei.request.SCRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GaoQingming on 2018/2/6 0006.
 */
@Service
public class SCServiceImpl implements SCService {
    @Autowired
    private SCMapper scMapper;
    public List<SCDTO> selectSCList(SCRequest scRequest) {
        List<SCDomain> scDomainList = scMapper.selectSCList(scRequest);
        return com.gaofei.utils.BeanUtils.copyListBeans(scDomainList,new ArrayList(),SCDomain.class,SCDTO.class);
    }
}
