package com.study.mapper;

import com.study.dto.GeneralTestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GeneralTestMapper {

    public void addOneEntry(GeneralTestDTO generalTestDTO);
    public void addBatches();
}
