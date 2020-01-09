package com.shijing.nopainnogain.designpattern.proxy.staticproxy;

public class Test {
    public static void main(String[] args) {
        // 创建目标对象
        TeacherDao teacherDao = new TeacherDao();

        // 创建代理对象，同时将被代理对象传递给代理对象
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);

        // 通过代理对象，调用到被代理对象的方法
        teacherDaoProxy.teach();
    }
}