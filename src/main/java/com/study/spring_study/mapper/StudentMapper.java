package com.study.spring_study.mapper;

import com.study.spring_study.pojo.Students;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: Demx James
 * @Date: 2023/01/08/17:19
 * @Description:
 */
// Mapper 根据ID在数据库中查询
@Mapper
@Repository
public interface StudentMapper {
    @Select("SELECT * FROM students WHERE id=#{id}")
    Students findById(long id);

}
