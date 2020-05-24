package com.shijing.nopainnogain.algorithm.dy;

import java.util.Arrays;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * 示例：
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * @description:
 * @author: shijing
 * @create: 2020-05-20 23:48
 **/
public class SumRange {

    private int[] sum;

    public static void main(String[] args) {

        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};

        SumRange sumRange = new SumRange();
        sumRange.numArray(nums);

        Arrays.stream(sumRange.sum).forEach(System.out::println);

        System.out.println("sumRange(0,2)=" + sumRange.sumRange(0, 2));
        System.out.println("sumRange(2,5)=" + sumRange.sumRange(2, 5));
        System.out.println("sumRange(0,5)=" + sumRange.sumRange(0, 5));
    }

    public void numArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

}
