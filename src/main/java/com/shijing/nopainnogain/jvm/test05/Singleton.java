package com.shijing.nopainnogain.jvm.test05;

/**
 * @Auther: shijing
 * @Date: 19/4/20 17 43
 * @Description:
 */
public class Singleton {
    private static Singleton instance = new Singleton();
    private static int x = 0;
    private static int y;
    private Singleton() {
        x++;
        y++;
    }
    public static Singleton getInstance() {
        return instance;
    }
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }
}
