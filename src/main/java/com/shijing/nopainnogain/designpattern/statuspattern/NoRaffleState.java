package com.shijing.nopainnogain.designpattern.statuspattern;

/**
 * @description: 不能抽奖的状态
 * @author: shijing
 * @create: 2020-01-16 22:15
 **/
public class NoRaffleState extends State{

    private Activity activity;

    public NoRaffleState(Activity activity) {
        this.activity = activity;
    }

    // 当前状态可以扣除积分，扣除后，将状态设置成可以抽奖状态
    @Override
    public void deduceMoney() {
        System.out.println("扣除50积分成功，您可以抽奖了");
        activity.setState(activity.getCanRaffleState());
    }

    // 当前状态不能抽奖
    @Override
    public boolean raffle() {
        System.out.println("扣了积分才能抽奖喔");
        return false;
    }

    // 当前状态不能发奖品
    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
