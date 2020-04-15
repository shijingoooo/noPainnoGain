package com.shijing.nopainnogain.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable {
    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getId() + "\t invoke sendSMS()");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getId() + "\t invoke sendEmail()");
    }

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    private void get() {
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + "\t invoke get()");
            set();
        } finally {
            lock.unlock();
        }
    }

    private void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + "\t invoke set()");
        } finally {
            lock.unlock();

        }
    }
}

/**
 * 可重入锁（递归锁）
 * 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
 * 在同一线程在外层获取锁的时候，在进入内层方法会自动获取锁
 * 也即是说，线程可以进入任何一个它已经拥有的锁同步着的代码块。
 * <p>
 * 14	 invoke sendSMS()
 * 14	 invoke sendEmail()
 * 15	 invoke sendSMS()
 * 15	 invoke sendEmail()
 *
 * ReentrantLock
 * 16	 invoke get()
 * 16	 invoke set()
 * 17	 invoke get()
 * 17	 invoke set()
 *
 **/
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();

        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);
        t3.start();
        t4.start();

    }
}
