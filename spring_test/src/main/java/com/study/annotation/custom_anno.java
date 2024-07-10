package com.study.annotation;



public class custom_anno {

    @MyAnnotation(value = "Hello", number = 10)
    public void myMethod() {
        System.out.println("MyMethod called");
    }

    public void antherMethod(){
        System.out.println("Another called");
    }
}
