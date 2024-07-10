package com.study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 注解可以用在方法上
@Retention(RetentionPolicy.RUNTIME) // 注解在运行时可用
public @interface MyAnnotation {
    String value();

    int number() default 0;
}
