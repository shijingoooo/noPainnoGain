package com.shijing.nopainnogain.designpattern.decoratorpattern;

/**
 * 饮料店抽象基类
 */
public abstract class Berverage {
    public String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public abstract int Cost();
}
