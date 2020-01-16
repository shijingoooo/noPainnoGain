package com.shijing.nopainnogain.designpattern.statuspattern;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-16 22:19
 **/
public class Test2 {
    public static void main(String[] args) {
        Activity activity = new Activity(1);

        for (int i = 0; i < 10; i++) {
            System.out.println("---第" + (i+1) + "次抽奖---");
            activity.deduceMoney();
            // 第二步抽奖
            activity.raffle();

        }
    }
}
