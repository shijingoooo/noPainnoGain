package com.shijing.nopainnogain.designpattern.statuspattern;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-16 22:15
 **/
public class DispenseState extends State{

    private Activity activity;

    public DispenseState(Activity activity) {
        this.activity = activity;
    }

    //
    @Override
    public void deduceMoney() {
        System.out.println("不能扣除积分");
    }

    @Override
    public boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    // 发放奖品
    @Override
    public void dispensePrize() {
        if (activity.getCount() > 0) {
            System.out.println("恭喜中奖了");
            // 改变状态为不能抽奖
            activity.setState(activity.getNoRaffleState());
        } else {
            System.out.println("很遗憾，奖品发送完了");
            // 改变状态为奖品发送完毕，后面我们就不可以抽奖
            activity.setState(activity.getDispenseOutState());
        }
    }
}
