package com.shijing.nopainnogain.algorithm.dy;

/**
 * @description:
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @author: shijing
 * @create: 2020-05-11 23:36
 **/
public class ClimbStairs {

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int n = 40;

        System.out.println("斐波那契数列");
        System.out.println("n=" + n + "\tresult=" + climbStairs.fib(n));

        System.out.println("动态规划");
        System.out.println("n=" + n + "\tresult=" + climbStairs.dy(n));
    }

    public int dy(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        if (n < 0) {
            return 0;
        }
        if (n < 3) {
            return arr[n];
        }
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    /**
     * 斐波那契数列
     * f(n) = f(n-1) + f(n-2);
     */
    public int fib(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int result = 0;
        if(n > 2) {
            int first = 1;
            int second = 2;
            for(int i = 3;i <= n;i++) {
                result = first + second;
                first = second;
                second = result;
            }
        }
        return result;
    }

}
