package com.shijing.nopainnogain.Demo.prodconsumer;

import java.util.concurrent.Semaphore;

/**
 * @description: 使用 Semaphore 实现生产者消费者
 * @author: shijing
 * @create: 2020-03-19 23:16
 **/

class MyShare {

    private static int count = 0;
    private final Semaphore notEmpty = new Semaphore(10);
    private final Semaphore empty = new Semaphore(0);
    private final Semaphore mutex = new Semaphore(1);

    public void prod() {
        try {
            // 没有满，可以生产
            notEmpty.acquire();
            // 互斥锁
            mutex.acquire();

            System.out.println("开始生产，当前库存：" + ++count);

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            empty.release();
        }
    }

    public void cons() {
        try {
            // 没有满，可以生产
            empty.acquire();
            // 互斥锁
            mutex.acquire();

            System.out.println("开始消费，当前库存：" + --count);
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            notEmpty.release();
        }

    }

}

public class SemaphoreImpl {


    public static void main(String[] args) {

        MyShare myShare = new MyShare();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    myShare.prod();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, "CCC").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    myShare.cons();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, "BBB").start();
    }

}
