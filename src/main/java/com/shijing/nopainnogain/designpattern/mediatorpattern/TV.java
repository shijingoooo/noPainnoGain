package com.shijing.nopainnogain.designpattern.mediatorpattern;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-01-15 21:16
 **/
public class TV extends Colleague {

    public TV(Mediator mediator, String name) {
        super(mediator, name);
        mediator.register(name, this);
    }

    @Override
    public void sendMessage(int stateChange) {
        this.getMediator().getMessage(stateChange, this.name);
    }

    public void startTV() {
        System.out.println("It's time to startTV");
    }

    public void stopTV() {
        System.out.println("It's time to stopTV");
    }
}
