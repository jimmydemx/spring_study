package com.study.annotation;


import com.study.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * There are many properties en database, that need to be filled automatically
 * i.e. create_time, update_time
 * those property can use annotation (for mapper) and add
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
    // 数据库操作类型,Update Insert
    OperationType value();

}
