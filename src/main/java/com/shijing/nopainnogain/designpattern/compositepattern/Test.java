package com.shijing.nopainnogain.designpattern.compositepattern;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-06 22:02
 **/
public class Test {
    public static void main(String[] args) {
        OrganizationComponent university = new University("清华大学", "中国顶级大学");

        College college1 = new College("计算机学院", "计算机");
        College college2 = new College("信息工程学院", "信息工程");

        college1.add(new Department("软件工程", "一级学科"));
        college1.add(new Department("网络工程", "二级学科"));
        college1.add(new Department("计算机科学与技术", "一级学科"));

        college2.add(new Department("通信工程", "难学"));
        college2.add(new Department("信息工程", "好学"));

        university.add(college1);
        university.add(college2);

        university.print();

        /**
         * 1. Map 就是一个抽象的构建（类似我们的Component)
         * 2. HashMap 是一个中间的构建（Composite）,实现/继承了相关方法
         *    put、putAll
         * 3. Node 是 HashMap 的静态内部类，类似Leaf叶子节点，没有 put、putAll 方法
         */
    }
}
