package com.shijing.nopainnogain.algorithm.dy;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 *
 * @description:
 * @author: shijing
 * @create: 2020-06-28 21:49
 **/
public class LengthOfLIS {

    public static void main(String[] args) {

        int[] a = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int[] b = new int[]{0};

        LengthOfLIS l = new LengthOfLIS();

        System.out.println(l.lengthOfLIS(b));

    }

    public int lengthOfLIS(int[] nums) {
        int[] temp = new int[nums.length];

        temp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxVal = 0;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, temp[j]);
                }
            }

            temp[i] = maxVal + 1;

            max = Math.max(max, temp[i]);
        }

        return max;
    }

}
