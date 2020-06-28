package com.shijing.nopainnogain.algorithm.array;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * @description:
 * @author: shijing
 * @create: 2020-06-27 15:12
 **/
public class MoveZeroes {

    public static void main(String[] args) {

        int[] a = new int[]{0, 0};

        MoveZeroes m = new MoveZeroes();
        m.move(a);

        System.out.println(Arrays.toString(a));
    }

    public void move(int[] nums) {
        int i = 0;
        int j = 0;
        int length = nums.length;

        while (i < length) {
            if (nums[i] != 0) {
                nums[j++] = nums[i++];
            } else {
                i++;
            }
        }


        do {
            nums[j++] = 0;
        } while (j < length);
    }
}
