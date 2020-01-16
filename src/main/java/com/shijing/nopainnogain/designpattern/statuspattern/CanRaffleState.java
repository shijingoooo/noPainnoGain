package com.shijing.nopainnogain.designpattern.statuspattern;

import java.util.Random;

/**
 * @description: 可以抽奖的状态
 * @author: shijing
 * @create: 2020-01-16 22:15
 **/
public class CanRaffleState extends State{

    private Activity activity;

    public CanRaffleState(Activity activity) {
        this.activity = activity;
    }

    // 已经扣除了积分不能再扣了
    @Override
    public void deduceMoney() {
        System.out.println("已经扣除了积分");
    }

    // 可以抽奖，抽完奖后，根据实际情况，改成新的状态
    @Override
    public boolean raffle() {
        System.out.println("正在抽奖，请稍等！");
        Random r = new Random();
        int num = r.nextInt(10);
        // 10%中奖机会
        if (num < 3) {
            //改变活动状态为发放奖品
            activity.setState(activity.getDispenseState());
            return true;
        } else {
            System.out.println("很遗憾没有抽中奖品！");
            // 改变状态为不能抽奖
            activity.setState(activity.getNoRaffleState());
            return false;
        }
    }

    // 不能发放奖品
    @Override
    public void dispensePrize() {
        System.out.println("没中奖，不能发放奖品");
    }
}
