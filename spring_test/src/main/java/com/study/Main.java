package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //开启注解方式的事务管理
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(Main.class, args);

    }
}
