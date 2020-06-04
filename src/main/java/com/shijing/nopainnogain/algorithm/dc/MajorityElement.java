package com.shijing.nopainnogain.algorithm.dc;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @description:
 * @author: shijing
 * @create: 2020-06-03 22:26
 **/
public class MajorityElement {

    public static void main(String[] args) {

        int[] a = new int[]{3, 2, 3};
        int[] b = new int[]{2, 2, 1, 1, 1, 2, 2};

        MajorityElement m = new MajorityElement();

        System.out.println("a的众数=" + m.majorityElement(a));
        System.out.println("b的众数=" + m.majorityElement(b));

    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }

        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }
}
