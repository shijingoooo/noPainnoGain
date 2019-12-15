package com.shijing.nopainnogain.designpattern.factorypattern.simplefactory;

public class CircleShape implements Shape {

    public CircleShape() {
        System.out.println("CircleShape: created");
    }

    @Override

    public void draw() {
        System.out.println("draw: CircleShape");
    }
}
