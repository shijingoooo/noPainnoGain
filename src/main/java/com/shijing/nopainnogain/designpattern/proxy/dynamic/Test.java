package com.shijing.nopainnogain.designpattern.proxy.dynamic;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-01-09 22:17
 **/
public class Test {
    public static void main(String[] args) {
        // 创建目标对象
        TeacherDao targer = new TeacherDao();
        // 给目标对象创建代理对象，可以转成ITeacherDao
        ITeacherDao proxyInstance =(ITeacherDao) new ProxyFactory(targer).getProxyInstance();
        // class com.sun.proxy.$Proxy0 内存中动态生成了代理对象
        System.out.println(proxyInstance);
        // 通过代理对象，调用目标对象的方法
    }
}
