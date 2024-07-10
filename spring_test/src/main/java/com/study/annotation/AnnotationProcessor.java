package com.study.annotation;

import java.lang.reflect.Method;

public class AnnotationProcessor {

    public static void main(String[] args) {
        try{
            Class<?> cls = custom_anno.class;
            Method myMethod = cls.getMethod("myMethod");

            System.out.print("declared Anotation: "+cls.getDeclaredAnnotations()+'\n'); //
            System.out.print("declared Methods: "+cls.getMethods().toString()+'\n'); // 只返回公有方法的数组
            System.out.print("declared DeclaredMethods: "+cls.getDeclaredMethods().toString()+'\n');
            System.out.print("declared Name: "+cls.getName()+'\n');
            System.out.print("declared AnnotatedInterfaces: "+cls.getAnnotatedInterfaces()+'\n');

            if (myMethod.isAnnotationPresent(MyAnnotation.class)){

                /**
                 *  Call Method: myMethod in the class
                 *  step1: get class instance
                 *  step2: invoke
                 */
                Object obj = cls.getDeclaredConstructor().newInstance();
                myMethod.invoke(obj);

                MyAnnotation annotation = myMethod.getAnnotation(MyAnnotation.class);
                System.out.println("Value: " + annotation.value());
                System.out.println("Number: " + annotation.number());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
