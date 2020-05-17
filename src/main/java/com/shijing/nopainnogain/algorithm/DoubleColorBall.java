package com.shijing.nopainnogain.algorithm;

import cn.hutool.core.util.RandomUtil;

import java.util.*;

/**
 * @description: 随机五注双色球
 * @author: shijing
 * @create: 2020-05-16 22:49
 **/
public class DoubleColorBall {

    private Set<String> red = new HashSet<>();

    private Set<String> blue = new HashSet<>();

    public DoubleColorBall() {
        for (int i = 1; i < 33; i++) {
            String value = String.valueOf(i);
            if (value.length() == 1) {
                value = "0" + value;
            }
            red.add(value);
            if (i <= 16) {
                blue.add(value);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        DoubleColorBall doubleColorBall = new DoubleColorBall();

        System.out.println();
        System.out.println("-----随机五注双色球-----");
        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.println(doubleColorBall.one());
        }

        System.out.println();

        Thread.sleep(100);
    }

    private List<String> one() {

        List<String> result = new ArrayList<>();

        Set<String> red = new TreeSet<>(String::compareTo);
        Set<String> randomEleSet = RandomUtil.randomEleSet(this.red, 6);

        red.addAll(randomEleSet);

        Set<String> blue = RandomUtil.randomEleSet(this.blue, 1);

        result.addAll(red);
        result.addAll(blue);

        return result;
    }

}
