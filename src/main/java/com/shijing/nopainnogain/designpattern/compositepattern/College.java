package com.shijing.nopainnogain.designpattern.compositepattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-06 21:59
 **/
public class College extends OrganizationComponent {

    public College(String name, String des) {
        super(name, des);
    }
    // 包含Department
    private List<OrganizationComponent> componentList = new ArrayList<>();

    @Override
    public void add(OrganizationComponent component) {
        componentList.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        componentList.remove(component);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    /**
     * 输出 University 包含的学院
     */
    @Override
    public void print() {
        System.out.println("---" + getName() + "---");
        // 遍历
        for (OrganizationComponent component1 : componentList) {
            component1.print();
        }
    }
}
