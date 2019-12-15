package com.shijing.nopainnogain.designpattern.factorypattern.abstractfactory;

public class Test {
    public static void main(String[] args) {
        SystemFactory mFactory;
        UIController interfaceController;
        OperationController operationController;

        //Android
        mFactory=new AndroidFactory();
        interfaceController=mFactory.createInterfaceController();
        operationController=mFactory.createOperationController();
        interfaceController.display();
        operationController.control();
        //Ios
        mFactory=new IosFactory();
        interfaceController=mFactory.createInterfaceController();
        operationController=mFactory.createOperationController();
        interfaceController.display();
        operationController.control();
        //Wp
        mFactory=new WpFactory();
        interfaceController=mFactory.createInterfaceController();
        operationController=mFactory.createOperationController();
        interfaceController.display();
        operationController.control();
    }
}
