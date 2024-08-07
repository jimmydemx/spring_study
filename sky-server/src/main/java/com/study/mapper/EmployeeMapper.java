package com.study.mapper;

import com.github.pagehelper.Page;
import com.study.annotation.AutoFill;
import com.study.dto.EmployeeDTO;
import com.study.dto.EmployeePageQueryDTO;
import com.study.dto.EmployeeStatusDTO;
import com.study.entity.Employee;
import com.study.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    @Insert("insert into employee(name,username,password,phone,sex,id_number,create_time,update_time,create_user,update_user,status)"
            + "values" +
            "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser},#{status})")
    @AutoFill(value = OperationType.INSERT)
    void insert(Employee employee);


    /**
     *
     */
    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    @AutoFill(value = OperationType.INSERT)
   void update(Employee employee);

   @Select("select * from employee where id=#{id}")
   Employee getById(Long id);

}
