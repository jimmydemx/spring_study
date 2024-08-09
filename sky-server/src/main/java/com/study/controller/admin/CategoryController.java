package com.study.controller.admin;

import com.study.dto.CategoryDTO;
import com.study.entity.Category;
import com.study.result.Result;
import com.study.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin/category")
@Api(tags="分类的接口")
@Slf4j
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @GetMapping("/list")
    @ApiOperation("按类型查找")
    private Result<ArrayList<Category>> GetListByType(Integer type){
        log.info("按照类型查找 {},",type);
          ArrayList<Category> list = categoryService.getListByType(type);
        return Result.success(list);

    }


//    @PostMapping('')



    @PutMapping("/update")
    @ApiOperation("修改类型")
    private Result updateCategory(@RequestBody CategoryDTO categoryDTO){
        log.info("update the category: {}",categoryDTO);
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO,category);
        categoryService.update(category);
        return Result.success();
    }

}
