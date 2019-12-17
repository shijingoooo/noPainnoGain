package com.shijing.nopainnogain.designpattern.facadepattern;

public class Man {
    private String name;

    public Man(String name) {
        this.name = name;
    }

    public void drink(TeaWater teawater) {
        System.out.println(name + " 喝了" + teawater.getMsg());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

