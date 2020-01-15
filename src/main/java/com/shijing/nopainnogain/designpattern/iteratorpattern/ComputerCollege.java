package com.shijing.nopainnogain.designpattern.iteratorpattern;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-13 22:37
 **/
public class ComputerCollege implements College{

    Department[] departments;
    int numOfDepartment = 0; // 保存当前数组的对象个数

    public ComputerCollege() {
        this.departments = new Department[5];
        addDepartment("JAVA", "java");
        addDepartment("PHP", "php");
        addDepartment("C", "c");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departments[numOfDepartment] = department;
        numOfDepartment++;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
