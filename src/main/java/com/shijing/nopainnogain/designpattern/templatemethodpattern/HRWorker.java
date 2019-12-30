package com.shijing.nopainnogain.designpattern.templatemethodpattern;

public class HRWorker extends Worker{

    public HRWorker(String name) {
        super(name);
    }

    /**
     * 工作
     */
    @Override
    public void work() {
        System.out.println(name + "看简历-打电话-接电话");
    }
}
