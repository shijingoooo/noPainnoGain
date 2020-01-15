package com.shijing.nopainnogain.designpattern.iteratorpattern;

import java.util.List;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-13 22:35
 **/
public class InfoCollegeIteraotr implements Iterator {

    // 信息工程学院是以List方式存放系
    List<Department> departmentList;
    int index = -1; // 索引

    public InfoCollegeIteraotr(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public boolean hasNext() {
        if (index >= departmentList.size() - 1) {
            return false;
        } else {
            index++;
            return true;
        }
    }

    @Override
    public Object next() {
        return departmentList.get(index);
    }

    @Override
    public void remove() {

    }
}
