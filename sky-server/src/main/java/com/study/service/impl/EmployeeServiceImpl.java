package com.study.service.impl;

import com.github.pagehelper.Page;
import com.study.constant.PasswordConstant;
import com.study.constant.StatusConstant;
import com.study.dto.EmployeeDTO;
import com.study.dto.EmployeeLoginDTO;
import com.study.dto.EmployeePageQueryDTO;
import com.study.dto.EmployeeStatusDTO;
import com.study.entity.Employee;
import com.study.mapper.EmployeeMapper;
import com.study.result.PageResult;
import com.study.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import com.github.pagehelper.PageHelper;

import javax.swing.text.Utilities;
import java.time.LocalDateTime;
import java.util.List;

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
        PageHelper.startPage(employeePageQueryDTO.getPage(), employeePageQueryDTO.getPageSize());
        Page<Employee> page = employeeMapper.pageQuery(employeePageQueryDTO);
        long total = page.getTotal();
        List<Employee> records = page.getResult();
        return new PageResult(total,records);
    }

    @Override
    public String toggleStatus(Integer status,Long id){
//        Employee employee = new Employee();
//        employee.setStatus(status);
//        employee.setId(id);

        // Emplyee 设置了@Builder可以直接使用builder构造方法
        Employee employee = Employee.builder().status(status).id(id).build();
        employeeMapper.update(employee);
        return "";
    }


    @Override
    public Employee getById(Long id){
        Employee employee= employeeMapper.getById(id);
        employee.setPassword("****");
        return employee;
    }

    @Override
    public void update(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        employeeMapper.update(employee);
    }
}
