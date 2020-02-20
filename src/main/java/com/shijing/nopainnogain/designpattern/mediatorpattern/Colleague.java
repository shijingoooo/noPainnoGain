package com.shijing.nopainnogain.designpattern.mediatorpattern;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-01-15 20:51
 **/
public abstract class Colleague {

    private Mediator mediator;
    public String name;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void sendMessage(int stateChange);

    public Mediator getMediator() {
        return this.mediator;
    }
}
