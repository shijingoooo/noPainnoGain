package com.shijing.nopainnogain.designpattern.factorypattern.abstractfactory;

public class AndroidFactory implements SystemFactory{
    @Override
    public OperationController createOperationController() {
        return new AndroidOperationController();
    }

    @Override
    public UIController createInterfaceController() {
        return new AndroidUIController();
    }
}
