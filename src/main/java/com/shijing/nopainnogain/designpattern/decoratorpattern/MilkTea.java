package com.shijing.nopainnogain.designpattern.decoratorpattern;

public class MilkTea extends  Berverage {
    public MilkTea() {
        description = "this is a cup of milk tea";
    }

    @Override
    public int Cost() {
        return 6;
    }
}