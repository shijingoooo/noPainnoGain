package com.shijing.nopainnogain.demo.prodconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {
    private volatile boolean FLAG = true; //默认开启，进行生产+消费
    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue<String> blockingQueue;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());

    }

    public void myProd() throws Exception {
        String data;
        boolean retValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "大老板叫停了，表示FLAG=false，生产动作结束");
    }

    public void myConsumen() throws Exception {
        String result;
        while (FLAG) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result != null) {
                System.out.println(Thread.currentThread().getName() + "\t 消费蛋糕" + result + "成功");
            } else {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过2秒钟没有取到蛋糕，消费退出");
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void stop() throws Exception {
        this.FLAG = false;
    }

}

/**
 * volatile/CAS/atomicInteger/BlockQueue/线程交互/原子引用
 */
public class ProdConsumer_BlockQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);

        MyResource myResource = new MyResource(blockingQueue);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "Prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
            try {
                myResource.myConsumen();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "Cons").start();

        try {
            TimeUnit.SECONDS.sleep(5);
            myResource.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("5秒钟时间到，大老板main叫停，活动结束");
    }


}
