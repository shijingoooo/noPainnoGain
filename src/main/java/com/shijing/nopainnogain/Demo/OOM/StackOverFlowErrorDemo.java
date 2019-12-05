package com.shijing.nopainnogain.Demo.OOM;


public class StackOverFlowErrorDemo {
    public static void main(String[] args) {
        stackOverFlow();
    }

    private static void stackOverFlow() {
        stackOverFlow(); // java.lang.StackOverflowError
    }
}
