package com.shijing.nopainnogain.algorithm.dy;

/**
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
