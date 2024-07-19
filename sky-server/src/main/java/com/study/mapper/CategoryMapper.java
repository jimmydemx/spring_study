package com.study.mapper;


import com.study.entity.Category;
import com.study.service.CategoryService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Mapper
public interface CategoryMapper {

    ArrayList<Category> getByProperty(Category category);

}
