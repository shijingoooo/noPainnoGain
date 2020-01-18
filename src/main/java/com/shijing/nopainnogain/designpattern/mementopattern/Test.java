package com.shijing.nopainnogain.designpattern.mementopattern;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-15 22:41
 **/
public class Test {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // 保存状态1
        originator.setState("状态1");
        caretaker.add(originator.saveStateMemento());

        // 保存状态2
        originator.setState("状态2");
        caretaker.add(originator.saveStateMemento());

        // 保存状态3
        originator.setState("状态3");
        caretaker.add(originator.saveStateMemento());

        // 恢复到状态1
        System.out.println("当前的状态是=" + originator.getState());

        originator.getStateFromMemento(caretaker.get(0));

        System.out.println("当前的状态是=" + originator.getState());

    }
}
