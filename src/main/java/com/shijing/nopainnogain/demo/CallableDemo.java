package com.shijing.nopainnogain.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread2 implements Runnable{

    @Override
    public void run() {

    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("come in Callable");
        TimeUnit.SECONDS.sleep(3);
        return 1024;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws Exception{
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        Thread thread = new Thread(futureTask, "AAA");
        thread.start();
        System.out.println("before");
        while (!futureTask.isDone()) {

        }
        Integer result = futureTask.get();//建议放在最后
        System.out.println("after");
        System.out.println(result + 100);
    }
}
