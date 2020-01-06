package com.shijing.nopainnogain.designpattern.bridge;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-05 22:39
 **/
public abstract class Phone {
    private Brand brand;

    public Phone(Brand brand) {
        super();
        this.brand = brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void open() {
        brand.open();
    }

    public void close() {
        brand.close();
    }

    public void call() {
        brand.call();
    }
}
