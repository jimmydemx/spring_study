package com.study.controller.admin;
import com.study.dto.EmployeeDTO;

import com.study.result.Result;
import com.study.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/test")
    public String test(){
        return "test returned";
    }

    @PostMapping("/add")
    @ApiOperation("新增员工")
    public Result save(@RequestBody EmployeeDTO employeeDTO){
        log.info("新增员工: {}",employeeDTO);
        employeeService.save(employeeDTO);
        return Result.success();
    }
}
