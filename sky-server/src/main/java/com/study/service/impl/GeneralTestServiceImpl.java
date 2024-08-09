package com.study.service.impl;

import com.study.dto.GeneralTestDTO;
import com.study.mapper.GeneralTestMapper;
import com.study.service.GeneralTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeneralTestServiceImpl implements GeneralTestService {

    @Autowired
    GeneralTestMapper generalTestMapper;


    /**
     *
     * @param generalTestDTO
     * 使用了Transactional 当执行到Number a =  1/0;出现了错误，就会回退，最终不会操作generalTestMapper.addOneEntry(generalTestDTO);
     * 不使用Transactional，会执行这条语句，但是当执行到Number a =  1/0会抛出错误。
     */

    @Override
    @Transactional
    public void add(GeneralTestDTO generalTestDTO) {
        generalTestMapper.addOneEntry(generalTestDTO);
//        Number a =  1/0;
    }
}
