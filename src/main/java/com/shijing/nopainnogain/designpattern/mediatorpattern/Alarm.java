package com.shijing.nopainnogain.designpattern.mediatorpattern;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-01-15 21:01
 **/
public class Alarm extends Colleague {

    public Alarm(Mediator mediator, String name) {
        super(mediator, name);
        // 在创建Alarm，将自己放入到ConcreteMediator对象中[集合]
        mediator.register(name, this);
    }

    public void sendAlarm(int stateChange) {
        sendMessage(stateChange);
    }

    @Override
    public void sendMessage(int stateChange) {
        // 调用的中介者对象的getMessage
        this.getMediator().getMessage(stateChange, this.name);
    }
}
