package com.shijing.nopainnogain.designpattern.strategypattern;

public class Test {
    public static void main(String[] args) {
        Person person1 = new Person(new Strategy1());
        person1.exec();
        Person person2 = new Person(new Strategy2());
        person2.exec();
        Person person3 = new Person(new Strategy3());
        person3.exec();
    }

}
