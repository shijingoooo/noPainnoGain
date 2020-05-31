package com.shijing.nopainnogain.algorithm.array;

import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @description:
 * @author: shijing
 * @create: 2020-05-28 23:40
 **/
public class RemoveElement {

    public static void main(String[] args) {

        RemoveElement e = new RemoveElement();
        int[] a = new int[]{3, 2, 2, 3};

        int aLength = e.removeElement(a, 3);
        System.out.println("a.length=" + aLength);
        System.out.println("a[]=" + Arrays.toString(Arrays.copyOf(a, aLength)));

        int[] b = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int bLength = e.removeElement(b, 2);
        System.out.println("b.length=" + bLength);
        System.out.println("b[]=" + Arrays.toString(Arrays.copyOf(b, bLength)));
    }

    public int removeElement(int[] a, int num) {

        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != num) {
                a[j] = a[i];
                j++;
            }
        }

        return j;
    }
}
