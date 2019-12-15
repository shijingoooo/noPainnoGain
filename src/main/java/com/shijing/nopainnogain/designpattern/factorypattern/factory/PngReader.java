package com.shijing.nopainnogain.designpattern.factorypattern.factory;

public class PngReader implements Reader {
    @Override
    public void read() {
        System.out.print("read png");
    }
}
