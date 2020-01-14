package com.shijing.nopainnogain.designpattern.visitorpattern;

/**
 * @description:
 * @author: shijing
 * @create: 2020-01-13 21:31
 **/
public class Success extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男人给的评价是很成功");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女人给的评价是很成功");
    }
}
