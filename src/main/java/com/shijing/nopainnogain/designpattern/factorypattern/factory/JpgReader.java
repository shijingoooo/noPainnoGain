package com.shijing.nopainnogain.designpattern.factorypattern.factory;

public class JpgReader implements Reader {
    @Override
    public void read() {
        System.out.print("read jpg");
    }
}
