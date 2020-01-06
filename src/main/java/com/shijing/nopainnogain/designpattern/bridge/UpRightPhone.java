package com.shijing.nopainnogain.designpattern.bridge;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-05 22:42
 **/
public class UpRightPhone extends Phone {

    public UpRightPhone(Brand brand) {
        super(brand);
    }

    public void open() {
        super.open();
        System.out.println("直立手机");
    }

    public void close() {
        super.close();
        System.out.println("直立手机");
    }

    public void call() {
        super.call();
        System.out.println("直立手机");
    }
}
