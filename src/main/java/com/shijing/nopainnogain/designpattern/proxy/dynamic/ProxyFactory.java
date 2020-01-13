package com.shijing.nopainnogain.designpattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-01-09 22:04
 **/
public class ProxyFactory {
    // 维护一个目标对象，Object
    private Object targer;

    // 构造器，对target进行初始化
    public ProxyFactory(Object targer) {
        this.targer = targer;
    }

    /**
     * 给目标对象生成一个代理对象
     *
     * newProxyInstance(ClassLoader loader,
     *                  Class<?>[] interfaces,
     *                  InvocationHandler h)
     * 1. ClassLoader loader: 指定当前目标对象使用的类加载器，获取加载器的方法固定
     * 2. Class<?>[] interfaces: 目标对象实现的接口类型，使用泛型方法确认类型
     * 3. InvocationHandler h: 事情处理，执行目标对象的方法时，会触发事情处理器方法，
     *    会把当前执行
     */

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(targer.getClass().getClassLoader()
                , targer.getClass().getInterfaces()
                , (proxy, method, args) -> {
                    System.out.println("JDK代理开始...");
                    // 反射机制调用目标对象的方法
                    Object object = method.invoke(targer, args);
                    System.out.println("JDK代理提交...");
                    return object;
                });
    }
}
