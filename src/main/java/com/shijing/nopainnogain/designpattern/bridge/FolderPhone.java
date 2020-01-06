package com.shijing.nopainnogain.designpattern.bridge;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-05 22:41
 **/
public class FolderPhone extends Phone {

    public FolderPhone(Brand brand) {
        super(brand);
    }

    public void open() {
        super.open();
        System.out.println("折叠手机");
    }

    public void close() {
        super.close();
        System.out.println("折叠手机");
    }

    public void call() {
        super.call();
        System.out.println("折叠手机");
    }
}
