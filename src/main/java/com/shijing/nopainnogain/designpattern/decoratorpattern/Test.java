package com.shijing.nopainnogain.designpattern.decoratorpattern;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class Test {
    public static void main(String[] args) throws Exception {
        //珍珠奶茶
        Berverage berverage1 = new PearlsMilkTea();
        System.out.println(berverage1.getDescription() + "cost = " + berverage1.Cost());

        //绿茶加牛奶
        Berverage berverage = new GreenTea();
        berverage = new Milk(berverage);
        System.out.println(berverage.getDescription() + "cost = " + berverage.Cost());

        /**
         * 1. InputStream是抽象类，类似 Berverage
         * 2. FileInputStream 是 InputStream 子类，类似 GreenTea、MilkTea、PearlsMilkTea
         * 3. FilterInputStream 是 InputStream 子类，类似 CondimentDecorator 修饰者
         * 4. DataInputStream 是FilterInputStream 子类，具体的修饰者，类似 Milk
         * 5. FilterInputStream 类有 protected volatile InputStream in; 即含被装饰者
         * 6. 分析得出在JDK的IO体系中，就是使用装饰者模式
         */

        DataInputStream dis = new DataInputStream(new FileInputStream("d:\\abc.txt"));
        System.out.println(dis.read());
        dis.close();
    }

}
