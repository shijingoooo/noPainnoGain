package com.shijing.nopainnogain.designpattern.visitorpattern;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-13 21:32
 **/
public class Man extends Person {
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
