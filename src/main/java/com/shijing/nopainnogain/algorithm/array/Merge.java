package com.shijing.nopainnogain.algorithm.array;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 *
 * @description:
 * @author: shijing
 * @create: 2020-05-31 20:14
 **/
public class Merge {

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] n1 = new int[]{2, 3, 4, 0, 0, 0};
        int[] n2 = new int[]{1, 5, 6};

        merge.m(n1, 3, n2, n2.length);

        System.out.println(Arrays.toString(n1));

    }

    public void m(int[] n1, int n, int[] n2, int m) {

        while (n > 0 && m > 0) {
            if (n1[n - 1] > n2[m - 1]) {
                n1[n + m - 1] = n1[n - 1];
                n1[n - 1] = 0;
                n--;
            } else {
                n1[n + m - 1] = n2[m - 1];
                m--;
            }
        }

        while (m > 0) {
            n1[m - 1] = n2[m - 1];
            m--;
        }

    }
}
