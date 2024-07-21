package com.study.service;

import com.study.dto.DishDTO;
import org.springframework.beans.factory.annotation.Autowired;

public interface DishService {

    public void saveWithFlavor(DishDTO dishDTO);
}
