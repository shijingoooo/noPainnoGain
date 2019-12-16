package com.shijing.nopainnogain.designpattern.commandpattern;

public class Test {
    public static void main(String[] args) {
        Receiver receiver1 = new ConcreteReceiver1();
        Command command1 = new ConcreteCommand(receiver1);

        Invoker invoker = new Invoker(command1);
        invoker.setCommand(command1);
        invoker.call();

        Receiver receiver2 = new ConcreteReceiver2();
        Command command2 = new ConcreteCommand(receiver2);

        invoker.setCommand(command2);
        invoker.call();
    }
}
