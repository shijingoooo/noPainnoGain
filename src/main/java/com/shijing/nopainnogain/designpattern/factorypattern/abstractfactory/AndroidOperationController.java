package com.shijing.nopainnogain.designpattern.factorypattern.abstractfactory;

public class AndroidOperationController implements OperationController {
    @Override
    public void control() {
        System.out.println("AndroidOperationController");
    }
}
