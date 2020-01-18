package com.shijing.nopainnogain.designpattern.mementopattern;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-15 22:36
 **/
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }


}
