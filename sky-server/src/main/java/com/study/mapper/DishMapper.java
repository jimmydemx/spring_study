package com.study.mapper;

import com.github.pagehelper.Page;
import com.study.annotation.AutoFill;
import com.study.dto.DishPageQueryDTO;
import com.study.entity.Dish;
import com.study.enumeration.OperationType;
import com.study.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DishMapper {

    @Select("select count(id) from dish where category_id=#{categoryId}")
    Integer countByCategoryId(Long categoryId);

    @Select("select * from dish where id=#{id}")
    Dish getById(Long id);

    /**
     * 根据主键删除菜品数据
     *
     * @param id
     */
    @Delete("delete from dish where id = #{id}")
    void deleteById(Long id);
    @AutoFill(value = OperationType.INSERT)
    public void insert(Dish dish);

    public Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);
}
