package com.shijing.nopainnogain.designpattern.statuspattern;

/**
 * @description: 含有所有的状态对象
 * @author: shijing
 * @create: 2020-01-16 22:17
 **/
public class Activity {
    // 表示活动当前的状态，是变化
    private State state;
    // 奖品数量
    int count = 0;
    // 四个属性，表示四种状态

    private State noRaffleState = new NoRaffleState(this);
    private State canRaffleState = new CanRaffleState(this);
    private State dispenseState = new DispenseState(this);
    private State dispenseOutState = new DispenseOutState(this);

    // 构造器
    // 1. 初始化当前状态为noRaffleState（即不能抽奖的状态）
    // 2. 初始化奖品的数量
    public Activity(int count) {
        this.state = getNoRaffleState();
        this.count = count;
    }

    // 扣积分，调用当前状态的deduceMoney
    public void deduceMoney() {
        state.deduceMoney();
    }

    // 抽奖
    public void raffle() {
        // 如果当前的状态是抽奖成功
        if (state.raffle()) {
            // 领取奖品
            state.dispensePrize();
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        int curCount = count;
        count--;
        return curCount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getNoRaffleState() {
        return noRaffleState;
    }

    public State getCanRaffleState() {
        return canRaffleState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public State getDispenseOutState() {
        return dispenseOutState;
    }
}
