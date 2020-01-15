package com.shijing.nopainnogain.designpattern.iteratorpattern;

public interface College {

    public String getName();

    public void addDepartment(String name, String desc);

    Iterator createIterator();
}
