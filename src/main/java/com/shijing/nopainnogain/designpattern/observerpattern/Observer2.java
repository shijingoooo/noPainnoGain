package com.shijing.nopainnogain.designpattern.observerpattern;

public class Observer2 implements Observer {

    @Override
    public void update(String msg) {
        System.out.println("Observer2: " + msg);
    }
}
