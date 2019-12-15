package com.shijing.nopainnogain.designpattern.factorypattern.abstractfactory;

public class AndroidUIController implements UIController {
    @Override
    public void display() {
        System.out.println("AndroidInterfaceController");
    }
}