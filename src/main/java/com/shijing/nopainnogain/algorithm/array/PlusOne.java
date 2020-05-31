package com.shijing.nopainnogain.algorithm.array;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @description:
 * @author: shijing
 * @create: 2020-05-30 20:45
 **/
public class PlusOne {
    public static void main(String[] args) {

        PlusOne plusOne = new PlusOne();

        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{4, 3, 2, 1};
        int[] c = new int[]{9, 9, 9};


        int i = plusOne.plusOne(a, a.length - 1);
        if (i == -1) {
            a = new int[a.length + 1];
            a[0] = 1;
        }
        System.out.println(Arrays.toString(a));

        i = plusOne.plusOne(b, b.length - 1);
        if (i == -1) {
            b = new int[b.length + 1];
            b[0] = 1;
        }
        System.out.println(Arrays.toString(b));

        i = plusOne.plusOne(c, c.length - 1);
        if (i == -1) {
            c = new int[c.length + 1];

            c[0] = 1;
        }
        System.out.println(Arrays.toString(c));

    }

    public int plusOne(int[] a, int i) {
        if (i == -1) {
            return i;
        }
        int j = 0;
        if (a[i] == 9) {
            a[i] = 0;
            j = plusOne(a, i - 1);
        } else {
            a[i]++;
        }
        return j;
    }
}
