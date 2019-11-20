package com.shijing.nopainnogain.Demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2019-11-20 22:18
 **/
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
        /**
         * 1. 故障现象
         *      java.util.ConcurrentModificationException
         * 2. 导致原因
         *      并发争抢修改导致，参考花名册签名情况
         *      一个人正在写入，另外一个同学过来抢夺，导致数据不一致异常
         * 3. 解决方案
         *      1. Vector
         *      2. Collections.synchronizedList(new ArrayList<>());
         *      3. CopyOnWriteArrayList
         *
         *      public boolean add(E e) {
         *         final ReentrantLock lock = this.lock;
         *         lock.lock();
         *         try {
         *             Object[] elements = getArray();
         *             int len = elements.length;
         *             Object[] newElements = Arrays.copyOf(elements, len + 1);
         *             newElements[len] = e;
         *             setArray(newElements);
         *             return true;
         *         } finally {
         *             lock.unlock();
         *         }
         *     }
         *
         * 4. 优化建议
         */
    }
}
