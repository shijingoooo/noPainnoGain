package com.shijing.nopainnogain.designpattern.visitorpattern;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-13 21:30
 **/
public abstract class Action {
    public abstract void getManResult(Man man);

    public abstract void getWomanResult(Woman woman);
}
