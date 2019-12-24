package com.shijing.nopainnogain.designpattern.observerpattern;

public class Test {
    public static void main(String[] args) {
        ObjectFor3D objectFor3D = new ObjectFor3D();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();

        objectFor3D.registerObserver(observer1);
        objectFor3D.registerObserver(observer2);

        objectFor3D.notifyObservers("hello world");

        objectFor3D.removeObserver(observer1);

        objectFor3D.notifyObservers("H");
    }
}
