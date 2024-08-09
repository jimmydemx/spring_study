package com.study.controller.admin;

import com.study.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Api("店铺相关接口")
@Slf4j
public class ShopController {

    @Autowired
    private RedisTemplate redisTemplate;


    @PutMapping("/{status}")
    @ApiOperation("设置店铺营业状态")
    public Result changeState(@PathVariable Integer status){
        log.info("The shop is on serice?: ", status==1? "On service":"Off Service");
        redisTemplate.opsForValue().set("SHOP_STATUS",status);
        return Result.success();
    }


    @GetMapping("/status")
    @ApiOperation("获取店铺营业状态")
    public Result<Integer> getStatus(){
        Integer status = (Integer)redisTemplate.opsForValue().get("SHOP_STATUS");
        log.info("The shop is on serice?: ", status==1? "On service":"Off Service");
        return Result.success(status);
    }

}
