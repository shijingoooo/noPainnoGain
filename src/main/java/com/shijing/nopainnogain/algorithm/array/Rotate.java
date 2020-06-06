package com.shijing.nopainnogain.algorithm.array;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * @description:
 * @author: shijing
 * @create: 2020-06-05 22:06
 **/
public class Rotate {

    public static void main(String[] args) {

        int a[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int b[] = new int[]{1};

        Rotate r = new Rotate();

        r.rotate(b , 2);

        System.out.println(Arrays.toString(b));

    }

    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length -1);

    }

    public void reverse(int[] nums, int start, int end) {

        int count = (end - start + 1) / 2;
        for (int i = 0; i < count; i++) {
            swap(nums, start, end);
            start++;
            end--;
        }

    }

    public void swap(int[] nums, int a, int b) {
        int temp;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void swap2(int[] nums, int start, int end) {
        nums[start] = nums[start] ^ nums[end];
        nums[end] = nums[start] ^ nums[end];
        nums[start] = nums[start] ^ nums[end];
    }

}
