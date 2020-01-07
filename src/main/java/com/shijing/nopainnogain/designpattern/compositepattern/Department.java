package com.shijing.nopainnogain.designpattern.compositepattern;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-06 21:59
 **/
public class Department extends OrganizationComponent {

    public Department(String name, String des) {
        super(name, des);
    }

    // add, remove 不需要写，因为他是叶子节点


    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    public void print() {
        System.out.println(getName());
    }
}
