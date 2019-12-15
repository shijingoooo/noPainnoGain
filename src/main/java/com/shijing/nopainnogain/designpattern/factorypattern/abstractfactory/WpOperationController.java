package com.shijing.nopainnogain.designpattern.factorypattern.abstractfactory;

public class WpOperationController implements OperationController {
    @Override
    public void control() {
        System.out.println("WpOperationController");
    }
}
