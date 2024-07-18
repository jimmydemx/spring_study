package com.study.bean_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

@Component
public class AnnotationProcessor {

    @Bean
    public void processor() {
        System.out.println("enter processor");
        Class<?> use = use_annotation.class;
        String name = use.getName();
        System.out.println("name: "+name);

    }
}
