package com.study.controller.admin;

import com.study.entity.Category;
import com.study.result.Result;
import com.study.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin/category")
@Api(tags="分类的接口")
@Slf4j
public class CategoryController {

//    @Autowired
//    CategoryService categoryService;
    @GetMapping("/list")
    @ApiOperation("按类型查找")
    private Result<ArrayList<Category>> GetListByType(Integer type){
        log.info("按照类型查找 {},",type);
//        ArrayList<Category> list = categoryService.getListByType(type);
        return Result.success();

    }


}
