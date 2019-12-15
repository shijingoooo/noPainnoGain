package com.shijing.nopainnogain.designpattern.factorypattern.abstractfactory;

public class IosUIController implements UIController {
    @Override
    public void display() {
        System.out.println("IosInterfaceController");
    }
}
