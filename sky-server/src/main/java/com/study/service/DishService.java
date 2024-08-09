package com.study.service;

import com.study.dto.DishDTO;
import com.study.dto.DishPageQueryDTO;
import com.study.result.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DishService {

    public void saveWithFlavor(DishDTO dishDTO);
    public PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    public void deleteBatch(List<Long> ids);
}
