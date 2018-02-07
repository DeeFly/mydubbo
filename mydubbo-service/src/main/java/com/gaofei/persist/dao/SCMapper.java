package com.gaofei.persist.dao;

import com.gaofei.persist.domain.SCDomain;
import com.gaofei.request.SCRequest;

import java.util.List;

/**
 * Created by GaoQingming on 2018/2/6 0006.
 */
public interface SCMapper {
    List<SCDomain>  selectSCList(SCRequest request);
}
