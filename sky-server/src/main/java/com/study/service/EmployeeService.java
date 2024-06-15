package com.study.service;

import com.study.dto.EmployeeDTO;
import com.study.dto.EmployeeLoginDTO;
import com.study.entity.Employee;

public interface EmployeeService {

    Employee login(EmployeeLoginDTO employeeLoginDTO);

    Employee save(EmployeeDTO employeeDTO);
}
