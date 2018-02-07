package com.gaofei.interf;

import com.gaofei.dto.SCDTO;
import com.gaofei.request.SCRequest;

import java.util.List;

/**
 * 选课表，或者成绩表，二合一了
 * Created by GaoQingming on 2018/2/6 0006.
 */
public interface SCService {
    List<SCDTO> selectSCList(SCRequest scRequest);
}
