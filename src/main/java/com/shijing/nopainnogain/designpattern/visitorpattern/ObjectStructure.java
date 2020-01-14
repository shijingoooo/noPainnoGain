package com.shijing.nopainnogain.designpattern.visitorpattern;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-13 21:41
 **/
public class ObjectStructure {
    private List<Person> personList = new LinkedList<>();

    // 增加到List
    public void attach(Person person) {
        personList.add(person);
    }

    // 移除
    public void detach(Person person) {
        personList.remove(person);
    }

    // 显示测评情况
    public void display(Action action) {
        for (Person p : personList) {
            p.accept(action);
        }
    }
}
