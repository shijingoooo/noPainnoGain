package com.shijing.nopainnogain.basic;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-28 15:19
 **/
public class trycatchDemo {

    public static void main(String[] args) {
        int y = aaa();
        System.out.println("y=" + y);
    }

    public static int aaa() {
        int x = 1;
        try {
            ++x;
            System.out.println("try x=" + x);
            return x;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ++x;
            System.out.println("finally x=" + x);
            //return x;
        }
        return x;
    }
}
