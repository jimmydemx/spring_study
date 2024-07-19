package com.study.service.impl;


import com.study.entity.Category;
import com.study.mapper.CategoryMapper;
import com.study.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public ArrayList<Category> getListByType(Integer type){
        Category category =new Category();
         category.setType(type);

        ArrayList<Category> result = categoryMapper.getByProperty(category);
        return result;

    }


}
