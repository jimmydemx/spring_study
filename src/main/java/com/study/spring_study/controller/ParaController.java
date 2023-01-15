package com.study.spring_study.controller;

import com.study.spring_study.pojo.Students;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Demx James
 * @Date: 2023/01/06/20:20
 * @Description:
 */
@RestController
public class ParaController {

    @GetMapping("/firstrequest")
    public String firstRequest(){
        return  "this is the first Interface";
    }

    @GetMapping("/para")
    public String requestPara(@RequestParam Integer num){
        num++;
        return "parameters recieved: "+ num;
    }

    @PostMapping("/post")
    public String postRequest(@RequestBody Students student){
        return "post parameters recieved: "+ student ;
    }
}
