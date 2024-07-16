package com.study.controller.admin;
import com.study.dto.EmployeeDTO;

import com.study.dto.EmployeeLoginDTO;
import com.study.dto.EmployeePageQueryDTO;
import com.study.dto.EmployeeStatusDTO;
import com.study.entity.Employee;
import com.study.result.PageResult;
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

    // query数据不需要 RequestBody

    /**
     * 员工分页查询
     * @param employeePageQueryDTO
     * @return
     */
    @GetMapping("page")
    @ApiOperation("员工分页查询")
    public  Result<PageResult> page(EmployeePageQueryDTO employeePageQueryDTO){
        log.info("员工分页查询, 参数为: {}",employeePageQueryDTO);
        PageResult pageResult = employeeService.pageQuery(employeePageQueryDTO);
        return Result.success(pageResult);
    }


    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用用户账号")
    public Result<String>  toggleStatus(@PathVariable Integer status, Long id){
       log.info("设置启用禁用用户账号：{},{}", status,id);
       String result=  employeeService.toggleStatus(status,id);
       return Result.success(result);
    }

    @GetMapping("/{id}")
    @ApiOperation("按照员工ID搜索")
    public  Result<Employee> getById(@PathVariable Long id){
        log.info("按照员工ID,{}",id);
        Employee employee = employeeService.getById(id);
        return Result.success(employee);
    }

    @PutMapping("")
    @ApiOperation("编译员工信息")
    public Result  updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        log.info("编译员工信息,{}",employeeDTO);
        employeeService.update(employeeDTO);
        return Result.success();
    }
}
