package com.shijing.nopainnogain.algorithm.dy;

/**
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * @description:
 * @author: shijing
 * @create: 2020-07-03 22:33
 **/
public class MaxProduct {
    public static void main(String[] args) {
        int[] a = new int[]{2, 3, -2, 4};
        int[] b = new int[]{-2, 0, -1};

        MaxProduct m = new MaxProduct();

        System.out.println(m.maxP(a));
        System.out.println(m.maxP(b));

    }

    public int maxP(int[] nums) {

        int l = nums.length;

        if (l == 0) {
            return 0;
        }

        if (l == 1) {
            return nums[0];
        }

        /**
         *  dp[i][0]：以 nums[i] 结尾的连续子数组的最小值
         *  dp[i][1]：以 nums[i] 结尾的连续子数组的最大值
         * */

        int[][] dp = new int[l][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < l; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
            } else {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
            }
        }

        int max = dp[0][1];
        for (int i = 1; i < l; i++) {
            max = Math.max(dp[i][1], max);
        }

        return max;
    }

}
