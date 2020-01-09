package com.shijing.nopainnogain.designpattern.singletonpattern;

public class Test {
    public static void main(String[] args) {
        // 多线程
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> System.out.println(Singleton6.instance.hashCode()), String.valueOf(i)).start();
        }
    }
}
