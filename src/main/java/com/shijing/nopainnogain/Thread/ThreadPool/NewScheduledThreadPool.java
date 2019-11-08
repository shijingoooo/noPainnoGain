package com.shijing.nopainnogain.Thread.ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: shijing
 * @Date: 19/4/22 15 23
 * @Description: 创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求
 */
public class NewScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);

        /*scheduledThreadPool.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);*/

        scheduledThreadPool.scheduleWithFixedDelay(new Runnable() {

            @Override
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);

    }
}
