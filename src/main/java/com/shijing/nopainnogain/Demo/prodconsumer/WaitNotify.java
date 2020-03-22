package com.shijing.nopainnogain.Demo.prodconsumer;

/**
 * @description: wait、notify实现
 * @author: shijing
 * @create: 2020-03-19 22:53
 **/

class MyData {
    private int count = 0;

    private static final int FULL = 10;

    private static final String LOCK = "lock";

    public void prod() throws InterruptedException {
        synchronized (LOCK) {
            while (count == FULL) {
                System.out.println("已满，停止生成");
                LOCK.wait();
            }

            count++;
            System.out.println("开始生产，当前库存=" + count);

            Thread.sleep(1000);

            LOCK.notifyAll();
        }
    }

    public void cons() throws InterruptedException {
        synchronized (LOCK) {
            while (count == 0) {
                System.out.println("已空，停止消费");
                LOCK.wait();
            }

            count--;
            System.out.println("开始消费，当前库存=" + count);

            Thread.sleep(1000);

            LOCK.notifyAll();
        }
    }
}

public class WaitNotify {

    public static void main(String[] args) {
        MyData myData = new MyData();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    myData.prod();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    myData.prod();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, "CCC").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    myData.cons();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, "BBB").start();


    }

}
