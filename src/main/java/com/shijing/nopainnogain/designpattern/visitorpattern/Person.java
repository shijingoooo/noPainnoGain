package com.shijing.nopainnogain.designpattern.visitorpattern;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-13 21:32
 **/
public abstract class Person {
    public abstract void accept(Action action);
}
