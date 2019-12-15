package com.shijing.nopainnogain.designpattern.factorypattern.factory;

public class JpgReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new JpgReader();
    }
}
