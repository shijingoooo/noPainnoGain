package com.shijing.nopainnogain.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序的代码实现虽然没有冒泡排序和选择排序那么简单粗暴，但它的原理应该是最容易理解的了，
 * 因为只要打过扑克牌的人都应该能够秒懂。插入排序是一种最简单直观的排序算法，它的工作原理是通过构建有序序列，
 * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 *
 * 算法步骤
 * 1. 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 * 2. 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
 * （如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 *
 */
public class InsertSortDemo {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 11, 33, 4, 6, 55, 22, 88, 65, 3, 2, 11, 9};
        InsertSort insertSort = new InsertSort();
        System.out.println("result: " + Arrays.toString(insertSort.sort(array)));
    }

    public static class InsertSort implements IArraySort {
        @Override
        public int[] sort(int[] sourceArray) {
            // 对 arr 进行拷贝，不改变参数内容
            int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
            // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
            for (int i = 1; i < arr.length; i++) {
                // 记录要插入的数据
                int tmp = arr[i];
                // 从已经排序的序列最右边的开始比较，找到比其小的数
                int j = i;
                while (j > 0 && tmp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                // 存在比其小的数，插入
                if (j != i) {
                    arr[j] = tmp;
                }
            }
            return arr;
        }
    }
}
