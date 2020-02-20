package com.shijing.nopainnogain.basic;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-28 14:32
 **/
public class ExchangeNumberDemo {
    public static void main(String[] args) {
        //method1();
        //method2();
        method3();
    }

    /**
     * 根据：
     * n ^ n = 0
     * n ^ 0 = n
     *
     * 初始值    n的值    m的值
     * n=n^m    n^m      m
     * m=n^m    n^m      n^m^m=n
     * n=n^m    n^m^n=m  n
     */
    private static void method3() {
        int n = 5;
        int m = 13;
        n = n ^ m;
        m = n ^ m;
        n = n ^ m;
        System.out.println("n=" + n);
        System.out.println("m=" + m);
    }

    private static void method2() {
        int n = 5;
        int m = 13;
        n = n + m;
        m = n - m;
        n = n - m;
        System.out.println("n=" + n);
        System.out.println("m=" + m);
    }

    private static void method1() {
        int n = 5;
        int m = 13;
        int temp = m;
        m = n;
        n = temp;

        System.out.println("n=" + n);
        System.out.println("m=" + m);
    }
}
