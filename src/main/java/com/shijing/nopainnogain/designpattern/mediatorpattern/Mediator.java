package com.shijing.nopainnogain.designpattern.mediatorpattern;

public abstract class Mediator {

    public abstract void register(String colleagueName, Colleague colleague);

    public abstract void getMessage(int stateChange, String colleague);

    public abstract void sendMessage();
}
