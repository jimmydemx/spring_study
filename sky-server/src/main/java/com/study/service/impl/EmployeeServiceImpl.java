package com.study.service.impl;

import com.study.constant.PasswordConstant;
import com.study.constant.StatusConstant;
import com.study.dto.EmployeeDTO;
import com.study.dto.EmployeeLoginDTO;
import com.study.dto.EmployeePageQueryDTO;
import com.study.entity.Employee;
import com.study.mapper.EmployeeMapper;
import com.study.result.PageResult;
import com.study.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import com.github.pagehelper.PageHelper;
import java.time.LocalDateTime;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public Employee login(EmployeeLoginDTO employeeLoginDTO) {
        return null;
    }


    @Override
    public Employee save(EmployeeDTO employeeDTO){
        Employee employee = new Employee();

        // copy properties
        BeanUtils.copyProperties(employeeDTO,employee);

        employee.setStatus(StatusConstant.ENABLE);

        // set password
        employee.setPassword(DigestUtils.md5DigestAsHex(PasswordConstant.DEFAULT_PASSWORD.getBytes()));

        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());

        //todo: has to changed the logging in user id
        employee.setCreateUser(10L);
        employee.setUpdateUser(10L);

        employeeMapper.insert(employee);
        return null;
    }

    @Override
    public PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO){

        // select * from employee limit 0,10
        PageHelper.startPage(employeePageQueryDTO);
//        Page .starPage(employeePageQueryDTO.getPage())
        return null;
    }
}
