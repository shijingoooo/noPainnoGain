package com.shijing.nopainnogain.designpattern.templatemethodpattern;

public class ManagerWorker extends Worker{

    public ManagerWorker(String name) {
        super(name);
    }

    /**
     * 工作
     */
    @Override
    public void work() {
        System.out.println(name + "打dota...");
    }
}
