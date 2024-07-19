package com.study.service;


import com.study.entity.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public interface CategoryService {

    ArrayList<Category> getListByType(Integer type);
}
