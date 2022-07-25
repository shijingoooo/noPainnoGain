package com.shijing.nopainnogain.thread.threadPool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: shijing
 * @Date: 19/4/22 16 29
 * @Description:
 */
public class NewWorkStealingPool {
    public static void main(String[] args) {
        ExecutorService workStealingPool = Executors.newWorkStealingPool();

        List<Callable<String>> callables = new ArrayList<>();
        for (int i = 1; i <= 16; i++) {
            final int count = i;
            Callable call = new Callable() {
                @Override
                public Object call() throws Exception {
                    Date now = new Date();
                    Thread.sleep(1000);//此任务耗时1s
                    return "线程" + Thread.currentThread().getName() + "完成任务："
                            + count + "   时间为：" + now.toLocaleString();
                }
            };
            callables.add(call);
        }

        //JDK1.8写法，打印执行结果
        //invokeAll可以批量提交一组线程
        try {
            workStealingPool.invokeAll(callables)
                    .stream()
                    .map(future -> {
                        try {
                            return future.get();
                        }
                        catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
