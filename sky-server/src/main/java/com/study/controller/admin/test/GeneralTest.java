package com.study.controller.admin.test;


import com.study.dto.GeneralTestDTO;
import com.study.result.Result;
import com.study.service.GeneralTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("General Test")
@RequestMapping("/test")
@Api(tags="一些测试接口")
@Slf4j
public class GeneralTest {


    @Autowired
    GeneralTestService generalTestService;
    @GetMapping
    @ApiOperation("FIRST TEST")
    public String firstTest(){
        return "first test returned";
    }


    /**
     * this is to test @transactional in various cases
     * case 1: if throw Exception occurs,
     */
    @PostMapping("/add")
    @ApiOperation("add row")
    public Result add(GeneralTestDTO generalTestDTO){
        log.info("add :{}",generalTestDTO);
        generalTestService.add(generalTestDTO);
        return Result.success();

    }

}
