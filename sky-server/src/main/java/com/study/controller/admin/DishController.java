package com.study.controller.admin;

import com.study.dto.DishDTO;
import com.study.result.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/dish")
@Api(tags="菜品相关接口")
@Slf4j
public class DishController {

    public Result Save(@RequestBody DishDTO dishDTO){
        log.info("新增菜品:{}",dishDTO);



        return Result.success();
    }


}
