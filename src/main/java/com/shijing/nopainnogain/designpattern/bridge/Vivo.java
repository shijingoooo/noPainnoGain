package com.shijing.nopainnogain.designpattern.bridge;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-05 22:40
 **/
public class Vivo implements Brand {
    @Override
    public void open() {
        System.out.println("vivo open...");
    }

    @Override
    public void close() {
        System.out.println("vivo close...");
    }

    @Override
    public void call() {
        System.out.println("vivo call...");
    }
}
