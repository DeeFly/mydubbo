package com.gaofei.persist.dao;

import com.gaofei.dto.PersonDetailDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by GaoQingming on 2018/3/1 0001.
 */
public interface PeopleDetailMapper {
    void saveDetails(@Param("list") List<PersonDetailDTO> list);

    void saveSingleDetails(@Param("person") PersonDetailDTO person);
}
