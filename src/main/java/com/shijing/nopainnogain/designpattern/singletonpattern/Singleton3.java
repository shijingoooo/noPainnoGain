package com.shijing.nopainnogain.designpattern.singletonpattern;

/**
 * 懒汉式【线程安全，效率低不推荐】
 */
public class Singleton3 {
    private Singleton3 instance = null;

    private Singleton3() {
    }

    public synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
    /**
     * public  Singleton3 getInstance() {
     *     if (instance == null) {
     *          synchronized(Singleton.class) {
     *             instance = new Singleton3();
     *          }
     *     }
     *     return instance;
     * }
     */
}
