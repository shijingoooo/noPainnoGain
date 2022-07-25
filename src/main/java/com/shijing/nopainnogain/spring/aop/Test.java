package com.shijing.nopainnogain.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author: shijing
 * @create: 2020-06-07 14:49
 **/
public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.shijing.nopainnogain.spring.aop");
        MathCalculator calculator = applicationContext.getBean(MathCalculator.class);
        int i = calculator.div(1, 1);
        System.out.println(i);
    }

}
