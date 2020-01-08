package com.shijing.nopainnogain.designpattern.flyweight;

/**
 * @description: 享元模式的外部状态
 * @author: shijing
 * @create: 2020-01-07 22:34
 **/
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
