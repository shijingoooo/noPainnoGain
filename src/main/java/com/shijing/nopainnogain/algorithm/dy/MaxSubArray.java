package com.shijing.nopainnogain.algorithm.dy;

/**
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 *
 * @author: shijing
 * @create: 2020-05-09 23:57
 **/
public class MaxSubArray {

    public static void main(String[] args) {

        MaxSubArray maxSubArray = new MaxSubArray();

        int[] a = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4, 3};

        long sum = maxSubArray.greed(a);

        System.out.println("贪心：最大和=" + sum);

        sum = maxSubArray.dy(a);
        System.out.println("动态规划：最大和=" + sum);
    }

    /**
     * 贪心算法，若当前元素之前的和小于0，则舍弃前面，重新计算
     */
    private int greed(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int sum = Integer.MIN_VALUE;
        int max = 0;

        for (int a : array) {
            if (sum < 0) {
                sum = a;
            } else {
                sum += a;
            }

            if (max < sum) {
                max = sum;
            }
        }

        return max;
    }

    /**
     * 动态规划，若前一个元素大于0，则加到当前元素上
     */
    private int dy(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int max = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > 0) {
                array[i] += array[i - 1];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }

        return max;

    }

}
