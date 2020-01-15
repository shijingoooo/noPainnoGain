package com.shijing.nopainnogain.designpattern.iteratorpattern;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-13 22:35
 **/
public class ComputerCollegeIterator implements Iterator{

    // 这里我们需要知道Department 是以怎样的方式存放

    Department[] departments;
    int position = 0; // 遍历位置

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        return position < departments.length && departments[position] != null;
    }

    @Override
    public Object next() {
        Department department = departments[position];
        position++;
        return department;
    }

    @Override
    public void remove() {

    }
}
