package com.shijing.nopainnogain.designpattern.singletonpattern;

/**
 * 懒汉式双重校验锁[推荐用]
 */
public class Singleton4 {
    /**
     * volatile确保当instance变量被初始化成Singleton实例时，
     * 多个线程正确的处理instance变量。
     */
    private volatile static Singleton4 instance;

    private Singleton4(){}

    public static Singleton4 getInstance(){
        if (instance==null) {//如果instance为null，就进入同步区。
            synchronized (Singleton4.class) {//只有第一次才执行到这里的代码
                if (instance==null) {//再次检查，如果仍是空，那么创建实例。
                    instance=new Singleton4();
                }
            }
        }
        return instance;
    }
}
