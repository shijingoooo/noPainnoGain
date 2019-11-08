package com.shijing.nopainnogain.Thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: shijing
 * @Date: 19/4/22 15 10
 * @Description: 创建固定大小的线程池。线程池的大小一旦达到最大值就会保持不变，
 * 如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
 */
public class NewFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread currentThread = Thread.currentThread();
                        long threadId = currentThread.getId();
                        System.out.println("Thread---" + threadId + ". Index---" + index);
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
