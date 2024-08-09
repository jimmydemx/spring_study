package com.study.service;


import com.study.entity.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public interface CategoryService {

    void update(Category category);

    ArrayList<Category> getListByType(Integer type);
}
