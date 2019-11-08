package com.shijing.nopainnogain.Thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: shijing
 * @Date: 19/4/22 16 11
 * @Description: 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，
 * 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
 */
public class NewSingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread currentThread = Thread.currentThread();
                        long threadId = currentThread.getId();
                        System.out.println("Thread---" + threadId + ". Index---" + index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
