package com.shijing.nopainnogain.designpattern.templatemethodpattern;

public class QAWorker extends Worker{

    public QAWorker(String name) {
        super(name);
    }

    /**
     * 工作
     */
    @Override
    public void work() {
        System.out.println(name + "写测试用例-提交bug-写测试用例");
    }
}
