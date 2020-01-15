package com.shijing.nopainnogain.designpattern.iteratorpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-13 22:37
 **/
public class InfoCollege implements College {

    List<Department> departmentList;

    public InfoCollege() {
        departmentList = new ArrayList<>();
        addDepartment("信息安全专业", "AAA");
        addDepartment("网络安全专业", "BBB");
        addDepartment("数据安全专业", "BBB");
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departmentList.add(department);
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollegeIteraotr(departmentList);
    }

}
