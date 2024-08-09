package com.study.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.study.constant.StatusConstant;
import com.study.dto.DishDTO;
import com.study.dto.DishPageQueryDTO;
import com.study.entity.Dish;
import com.study.entity.DishFlavor;
import com.study.exception.DeletionNotAllowedException;
import com.study.mapper.DishFlavorMapper;
import com.study.mapper.DishMapper;
import com.study.mapper.SetMealMapper;
import com.study.result.PageResult;
import com.study.service.DishService;
import com.study.vo.DishVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DishServiceImpl implements DishService {


    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private DishFlavorMapper dishFlavorMapper;


    @Autowired
    private SetMealMapper setMealMapper;

    /**
     *
     * @param dishDTO
     */
    @Override
    @Transactional
    public void saveWithFlavor(DishDTO dishDTO){

        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO,dish);
        // 向菜品表插入1条数据
        dishMapper.insert(dish);

        // 获取insert语句生成的主键值
        Long dishId = dish.getId();

        // 向口味表插入n条数据
        List<DishFlavor> flavors = dishDTO.getFlavors();
        if(flavors!=null && flavors.size()>0){
            flavors.forEach(dishFlavor->{
                dishFlavor.setDishId(dishId);
            });
                dishFlavorMapper.insertBatch(flavors);
        }
    }

    @Override
    public PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO){

        PageHelper.startPage(dishPageQueryDTO.getPage(), dishPageQueryDTO.getPageSize());
        Page<DishVO> page=  dishMapper.pageQuery(dishPageQueryDTO);
        return new PageResult(page.getTotal(),page.getResult());

    }

    @Override
    @Transactional
    public void deleteBatch(List<Long> ids) {
//        dishMapper.deleteBatch(ids);
//        dishMapper.deleteByDishIds(ids);

        for(Long id:ids){
            Dish dish = dishMapper.getById(id);
            if(dish.getStatus() == StatusConstant.ENABLE){
                throw  new DeletionNotAllowedException("status is enabled, deletion is not allowed");
            }
        }
        List<Long> setmealIdsByDishIds = setMealMapper.getSetmealIdsByDishIds(ids);

        if(setmealIdsByDishIds!=null && setmealIdsByDishIds.size()>0){
            throw  new DeletionNotAllowedException("Meal is set not able, delettion is not allowed ");
        }

        for(Long id:ids){
            dishMapper.deleteById(id);
            dishFlavorMapper.deleteByDishId(id);
        }
    }
}
