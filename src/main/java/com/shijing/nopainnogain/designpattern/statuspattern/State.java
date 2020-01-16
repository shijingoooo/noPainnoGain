package com.shijing.nopainnogain.designpattern.statuspattern;

/**
 * 各个状态含有Activity对象
 */
public abstract class State {
    // 扣除积分 -50
    abstract void deduceMoney();
    // 是否抽中奖品
    abstract boolean raffle();
    // 发放奖品
    abstract void dispensePrize();
}
