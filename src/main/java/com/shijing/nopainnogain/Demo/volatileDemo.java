package com.shijing.nopainnogain.Demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2019-11-18 22:16
 **/

class MyData {
    volatile int number = 0;
    //int number = 0;

    public void addTo60() {
        this.number = 60;
    }

    // 请注意，此时number有volatile修饰
    public synchronized void addPlusPlus() {
        number ++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1. 验证volatile可见性
 *   1.1 加入 int number = 0; number 变量之前根本没有添加volatile关键字修饰
 *   1.2 添加了volatile可以解决可见性问题。
 *
 * 2. 验证volatile不保证原子性
 *   2.1 原子性指的是什么意思？
 *       不可分割，完整性，也即某个线程正在某个具体业务时，中间不可以被加塞或者被分割需要整体完整
 *       要么同时成功，要么同时失败
 *   2.2 volatile不保证原子性
 *
 *   2.3 why
 *
 *   2.4 如何解决原子性？
 *       * 加 sync
 *       * 使用AtomicInteger
 */
public class volatileDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            }, String.valueOf(i)).start();
        }
        // 需要等待上面20个线程全部计算完成后，再用main线程查看值
        // 一个main线程 一个GC线程
        while(Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t finally int number value: " + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t finally AtomicInteger number value: " + myData.atomicInteger.get());
    }

    private static void seekOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update number value: " + myData.number);

        }, "AAA").start();

        // 第二个线程就是main线程
        while (myData.number == 0) {
            // main线程一直循环，知道number不等与0

        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }

}
