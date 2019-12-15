package com.shijing.nopainnogain.designpattern.factorypattern.abstractfactory;

public class IosOperationController implements OperationController {
    @Override
    public void control() {
        System.out.println("IosOperationController");
    }
}
