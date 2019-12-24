package com.shijing.nopainnogain.designpattern.observerpattern;

public class Observer1 implements Observer {

    @Override
    public void update(String msg) {
        System.out.println("Observer1: " + msg);
    }
}
