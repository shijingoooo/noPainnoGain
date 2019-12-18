package com.shijing.nopainnogain.designpattern.decoratorpattern;

public class GreenTea extends Berverage {

    public GreenTea () {
        description = "this is a cup of green tea ";
    }

    @Override
    public int Cost() {
        return 5;
    }
}


