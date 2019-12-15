package com.shijing.nopainnogain.designpattern.factorypattern.abstractfactory;

public interface SystemFactory {
    public OperationController createOperationController();
    public UIController createInterfaceController();
}