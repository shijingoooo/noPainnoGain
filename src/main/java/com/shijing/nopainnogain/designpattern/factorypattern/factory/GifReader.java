package com.shijing.nopainnogain.designpattern.factorypattern.factory;

public class GifReader implements Reader {
    @Override
    public void read() {
        System.out.print("read gif");
    }
}