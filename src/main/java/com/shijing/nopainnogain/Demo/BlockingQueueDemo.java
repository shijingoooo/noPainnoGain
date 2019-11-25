package com.shijing.nopainnogain.Demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ArrayBlockingQueue：是一个基于数组结构的有界阻塞队列，此队列按照FIFO（先进先出）原则对元素进行排序。
 * LinkedBlockingQueue：是一个基于链表结构的阻塞队列，此队列按照FIFO（先进先出）排序元素，吞吐量通常高于ArrayBlockingQueue/
 * SynchronousQueue：一个不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常
 *
 * 1. 队列
 *
 * 2. 阻塞队列
 *   2.1 阻塞队列有没有好的一面
 *
 *   2.2 不得不阻塞，你如何管理
 *
 *
 * 方法类型  抛出异常    特殊值     阻塞     超时
 * 插入       add(e)   offer(e)  put(e)  offer(e,time,unit)
 * 移除     remove()   poll()    take()  poll(time,unit)
 * 检查     element()  peek()   不可用    不可用
 */

public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception{
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        // 抛出异常
        /*System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //System.out.println(blockingQueue.add("d"));
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //System.out.println(blockingQueue.element());

        // 特殊值
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());*/

        // 超时
        /*blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        System.out.println("====================");
        //blockingQueue.put("d");

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        //blockingQueue.take();*/

        //
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("d", 2L, TimeUnit.SECONDS));

    }
}
