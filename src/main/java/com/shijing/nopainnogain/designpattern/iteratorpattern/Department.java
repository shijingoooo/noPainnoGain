package com.shijing.nopainnogain.designpattern.iteratorpattern;

/**
 * @description: 系
 * @author: shijing
 * @create: 2020-01-13 22:36
 **/
public class Department {
    private String name;

    private String desc;

    public Department(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
