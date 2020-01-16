package com.shijing.nopainnogain.designpattern.statuspattern;

/**
 * @description: 奖品发放完毕状态 当我们activity改变成 DispenseOutState, 抽奖活动结束
 * @author: shijing
 * @create: 2020-01-16 22:15
 **/
public class DispenseOutState extends State{

    private Activity activity;

    public DispenseOutState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void deduceMoney() {
        System.out.println("奖品发完了，请下次再参加");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发完了，请下次再参加");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发完了，请下次再参加");
    }
}
