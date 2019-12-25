package com.shijing.nopainnogain.designpattern.strategypattern;

/**
 * 执行策略
 *
 * 创建Thread类传入Runnable接口就是策略模式
 */
public class Person {
    private Strategy strategy;

    public Person(Strategy strategy) {
        this.strategy = strategy;
    }

    public void exec() {
        strategy.action();
    }
}
