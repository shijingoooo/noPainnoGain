package com.shijing.nopainnogain.designpattern.factorypattern.factory;

public class GifReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new GifReader();
    }
}
