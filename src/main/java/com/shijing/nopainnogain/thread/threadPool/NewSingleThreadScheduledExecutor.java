package com.shijing.nopainnogain.thread.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: shijing
 * @Date: 19/4/22 16 14
 * @Description: 创建一个单线程的线程池。此线程池支持定时以及周期性执行任务的需求
 */
public class NewSingleThreadScheduledExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newSingleThreadScheduledExecutor();
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }
}
