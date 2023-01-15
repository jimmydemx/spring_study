package com.study.spring_study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Demx James
 * @Date: 2023/01/08/16:51
 * @Description:
 */
@RestController
public class PropertiesController {
    @Value("${school.grade}")
    Integer grade;

    @Value("${school.classnum}")
    Integer classnum;



    static  Integer age;


    @GetMapping("/gradeclass")
    public String gradeClass(){
        return "grade: "+grade+ classnum;
    }

    /**
     * directly getMapping a static value will yield to null value
     */
    @GetMapping("/static")
    public  String staticPara(){
        return "state value: "+ age;
    }

    @Value("${school.age}")
    public void setAge(Integer age) {
        PropertiesController.age = age;
    }
}
