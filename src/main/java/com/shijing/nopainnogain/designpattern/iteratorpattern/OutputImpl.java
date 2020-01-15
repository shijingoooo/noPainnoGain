package com.shijing.nopainnogain.designpattern.iteratorpattern;

import java.util.List;

/**
 * @description: 完成对所有学院的输出
 * @author: shijing
 * @create: 2020-01-13 22:38
 **/
public class OutputImpl {

    // 学院集合
    List<College> collegeList;

    public OutputImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    public void printCollege() {
        java.util.Iterator<College> iterator = collegeList.iterator();

        while (iterator.hasNext()) {
            // 取出一个学院
            College college = iterator.next();
            System.out.println("==="+college.getName()+"===");
            printDepartment(college.createIterator());
        }
    }

    public void printDepartment(Iterator iterator) {
        while (iterator.hasNext()) {
            Department d = (Department) iterator.next();
            System.out.println(d.getName());

        }
    }
}
