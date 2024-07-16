package com.study.service;

import com.study.dto.EmployeeDTO;
import com.study.dto.EmployeeLoginDTO;
import com.study.dto.EmployeePageQueryDTO;
import com.study.dto.EmployeeStatusDTO;
import com.study.entity.Employee;
import com.study.result.PageResult;

public interface EmployeeService {

    Employee login(EmployeeLoginDTO employeeLoginDTO);

    Employee save(EmployeeDTO employeeDTO);

    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    String toggleStatus(Integer status,Long id);

    Employee getById(Long id);

    void update(EmployeeDTO employeeDTO);
}
