package com.shijing.nopainnogain.designpattern.decoratorpattern;

public class Milk extends CondimentDecorator {//牛奶
    Berverage berverage;

    public Milk(Berverage berverage) {
        this.berverage = berverage;
    }

    @Override
    public String getDescription() {
        return berverage.getDescription() + "+ milk ";
    }

    @Override
    public int Cost() {
        return berverage.Cost() + 3;
    }
}

