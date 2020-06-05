package com.shijing.nopainnogain.algorithm.dc;

/**
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @description:
 * @author: shijing
 * @create: 2020-06-04 21:29
 **/
public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray m = new MaxSubArray();

        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 0, 0};

        System.out.println(m.maxSub(nums, 0, nums.length - 1));
    }

    public int maxSub(int[] nums, int left, int right) {
        //一定将左右边界最大初始化为MIN_VALUE，初始化为0的时候全为负数过不去
        int maxleftbordersum = Integer.MIN_VALUE, maxrightbordersum = Integer.MIN_VALUE;
        int leftmaxsum, rightmaxsum;
        int leftbordersum = 0, rightbordersum = 0;

        int mid = left + (right - left) / 2;
        if (left == right) {
            return nums[left];
        }
        leftmaxsum = maxSub(nums, left, mid);        //计算得到左子数组的最大值
        rightmaxsum = maxSub(nums, mid + 1, right);    //计算得到右子数组的最大值

        for (int i = mid; i >= left; i--)        //一定要从中间向两端加！！！
        {
            leftbordersum += nums[i];
            if (leftbordersum > maxleftbordersum)
                maxleftbordersum = leftbordersum;
        }

        for (int i = mid + 1; i <= right; i++) {
            rightbordersum += nums[i];
            if (rightbordersum > maxrightbordersum)
                maxrightbordersum = rightbordersum;
        }
        //返回三者最大值
        return Integer.max(leftmaxsum, Integer.max(rightmaxsum, maxleftbordersum + maxrightbordersum));
    }

}
