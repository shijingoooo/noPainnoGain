package com.shijing.nopainnogain.designpattern.commandpattern;

public  class ConcreteCommand extends Command {
    private Receiver receiver; //维持一个对请求接收者对象的引用

    public ConcreteCommand(Receiver receiver) {
        super();
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action(); //调用请求接收者的业务处理方法action()
    }
}
