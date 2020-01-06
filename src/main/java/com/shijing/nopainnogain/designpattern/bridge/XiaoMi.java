package com.shijing.nopainnogain.designpattern.bridge;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-05 22:40
 **/
public class XiaoMi implements Brand {

    @Override
    public void open() {
        System.out.println("xiaomi open...");
    }

    @Override
    public void close() {
        System.out.println("xiaomi close...");
    }

    @Override
    public void call() {
        System.out.println("xiaomi call...");
    }
}
