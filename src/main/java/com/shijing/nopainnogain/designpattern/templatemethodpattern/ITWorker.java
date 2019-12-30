package com.shijing.nopainnogain.designpattern.templatemethodpattern;

public class ITWorker extends Worker{

    public ITWorker(String name) {
        super(name);
    }

    /**
     * 工作
     */
    @Override
    public void work() {
        System.out.println(name + "写程序-测bug-fix bug");
    }
}
