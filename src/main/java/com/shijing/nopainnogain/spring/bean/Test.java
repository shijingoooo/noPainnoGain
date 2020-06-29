package com.shijing.nopainnogain.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 打印结果
 *
 * 这是BeanFactoryPostProcessor实现类构造器！！
 * BeanFactoryPostProcessor调用postProcessBeanFactory方法
 * 这是BeanPostProcessor实现类构造器！！
 * 这是InstantiationAwareBeanPostProcessorAdapter实现类构造器！！
 * InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法
 * 【构造器】调用Person的构造器实例化
 * InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法
 * 【注入属性】注入属性address
 * 【注入属性】注入属性name
 * 【注入属性】注入属性phone
 * 【BeanNameAware接口】调用BeanNameAware.setBeanName()
 * 【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()
 * BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！
 * 【InitializingBean接口】调用InitializingBean.afterPropertiesSet()
 * 【init-method】调用<bean>的init-method属性指定的初始化方法
 * BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！
 * InstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法
 * Person [address=广州, name=张三, phone=110]
 *
 * @description:
 * @author: shijing
 * @create: 2020-06-07 10:07
 **/
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person p = applicationContext.getBean(Person.class);
        System.out.println(p);
    }
}
