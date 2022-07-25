package com.shijing.nopainnogain.basic;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-28 14:48
 **/
public class Test {
    public static void main(String[] args) {
        a();
    }

    private static void a() {
        int a = 60;
        String str1 = Integer.toBinaryString(60);
        String str2 = Integer.toHexString(60);
        System.out.println("str1=" + str1);
        System.out.println("str2=" + str2);
    }
}
