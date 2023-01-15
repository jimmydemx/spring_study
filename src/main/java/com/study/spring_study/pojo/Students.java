package com.study.spring_study.pojo;

import java.lang.reflect.Constructor;

/**
 * @Author: Demx James
 * @Date: 2023/01/06/20:42
 * @Description: student
 */
public class Students {
    Integer id;
    String name;

    @Override
    public String toString() {
        return "Student{" +
                "id="+id+
                ", name='"+name+'\''+
                '}';
        };

    public Students(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
