package com.shijing.nopainnogain.designpattern.commandpattern;

public class ConcreteReceiver2 extends Receiver{

    @Override
    public void action() {
        System.out.println("ConcreteReceiver2 receives the command!");
    }

}

