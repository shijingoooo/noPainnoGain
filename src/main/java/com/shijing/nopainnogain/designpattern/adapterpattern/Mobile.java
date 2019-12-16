package com.shijing.nopainnogain.designpattern.adapterpattern;

public class Mobile {
    public void inputPower(V5Power power) {
        int providerV5Power = power.provideV5Power();
        System.out.println("now is " + providerV5Power + "V");
    }
}
