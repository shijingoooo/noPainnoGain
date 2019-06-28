package com.shijing.nopainnogain.JVM.test03;

import java.util.concurrent.locks.Lock;

/**
 * @Auther: shijing
 * @Date: 19/4/15 20 48
 * @Description:
 */
public class DeamonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2000L);
        System.out.println("Main thread finished lifecycle.");

    }
}
