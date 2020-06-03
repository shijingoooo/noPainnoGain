package com.shijing.nopainnogain.algorithm.dy;

/**
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 *
 * @description:
 * @author: shijing
 * @create: 2020-06-03 21:52
 **/
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] a = new int[]{10, 15, 20};
        int[] b = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] c = new int[]{0, 0, 0, 1};
        int[] d = new int[]{0, 1, 1, 0};


        MinCostClimbingStairs m = new MinCostClimbingStairs();
        //System.out.println("a minCost = " + m.minCost(a));
        System.out.println("b minCost = " + m.minCost(b));
        //System.out.println("c minCost = " + m.minCost(c));
    }

    public int minCost(int a[]) {

        int length = a.length;

        for (int i = 2; i < length; i++) {
            a[i] = Math.min(a[i - 2], a[i - 1]) + a[i];
        }

        return Math.min(a[length - 2], a[length - 1]);
    }

}
