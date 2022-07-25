package com.shijing.nopainnogain.basic;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-28 14:15
 **/
public class OperatorDemo {
    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        int a = 1;
        int b = 2;
        System.out.println( a & ++b );
        System.out.println("b: " + b);

        boolean c = true;
        boolean d = false;
        System.out.println( c || (d = !d) );
        System.out.println(d);
    }
}
