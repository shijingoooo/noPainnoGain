package com.shijing.nopainnogain.Demo;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2019-11-18 22:56
 **/
public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    /** 可用synchronized 太重
     * DCL Double Check Lock 双端检锁机制 可能指令重排
     * 原因在于某一个线程执行到第一次检测，读取到的instance不为null时，instance的引用对象可能没有完成初始化。
     * instance = new SingletonDemo(); 可以分为以下3步完成
     * memory = allocate(); 1.分配对象内存空间
     * instance(memory);    2.初始化对象
     * instance = memory;   3.设置instance指向刚分配的内存地址，此时instance != null
     * 步骤2和步骤3不存在数据依赖关系，允许指令重排
     *
     * memory = allocate(); 1.分配对象内存空间
     * instance = memory;   3.设置instance指向刚分配的内存地址，此时instance != null
     * instance(memory);    2.初始化对象
     *
     * 解决 ： 加 volatile
    */
    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "我是构造方法");
    }

    public static void main(String[] args) {
        // 单线程
        /*System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
*/
        // 多线程
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }

}
