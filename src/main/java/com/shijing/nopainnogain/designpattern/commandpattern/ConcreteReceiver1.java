package com.shijing.nopainnogain.designpattern.commandpattern;

public class ConcreteReceiver1 extends Receiver{

    @Override
    public void action() {
        System.out.println("ConcreteReceiver1 receives the command!");
    }

}

