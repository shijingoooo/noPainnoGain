package com.shijing.nopainnogain.designpattern.compositepattern;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-01-06 21:58
 **/
public abstract class OrganizationComponent {
    private String name;
    private String des;

    public OrganizationComponent(String name, String des) {
        super();
        this.name = name;
        this.des = des;
    }

    public void add(OrganizationComponent component){}
    public void remove(OrganizationComponent component){}

    // 子类都需要实现
    public abstract void print();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
