package com.shijing.nopainnogain.algorithm.dy;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 * @description:
 * @author: shijing
 * @create: 2020-06-10 22:07
 **/
public class MaxDuration {

    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3, 1};
        int[] b = new int[]{2, 7, 9, 3, 1};
        int[] c = new int[]{2, 1, 4, 5, 3, 1, 1, 3};

        MaxDuration m = new MaxDuration();

        System.out.println("a=" + m.maxDuration(a));
        System.out.println("b=" + m.maxDuration(b));
        System.out.println("c=" + m.maxDuration(c));
    }

    public int maxDuration(int[] nums) {

        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        if (length == 1) {
            return nums[0];
        }

        int maxD = 0;
        nums[1] = Math.max(nums[0], nums[1]);
        if (length == 2) {
            return nums[1];
        }

        for (int i = 2; i < length; i++) {
            nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
            if (nums[i] > maxD) {
                maxD = nums[i];
            }
        }

        return maxD;
    }

}
