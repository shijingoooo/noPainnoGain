package com.shijing.nopainnogain.designpattern.decoratorpattern;

public class PearlsMilkTea extends Berverage {
    public PearlsMilkTea() {
        description = "this is a cup of pearls milk tea  ";
    }

    @Override
    public int Cost() {
        return 2;
    }
}