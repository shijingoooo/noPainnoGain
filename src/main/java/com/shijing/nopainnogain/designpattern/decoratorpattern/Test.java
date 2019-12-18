package com.shijing.nopainnogain.designpattern.decoratorpattern;

public class Test {
    public static void main(String[] args) {

        //珍珠奶茶
        Berverage berverage1 = new PearlsMilkTea();
        System.out.println(berverage1.getDescription() + "cost = " + berverage1.Cost());

        //绿茶加牛奶
        Berverage berverage = new GreenTea();
        berverage = new Milk(berverage);
        System.out.println(berverage.getDescription()+"cost = "+berverage.Cost());
    }

}
