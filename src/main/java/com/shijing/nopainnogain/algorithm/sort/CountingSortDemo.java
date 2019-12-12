package com.shijing.nopainnogain.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序的核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。作为一种线性时间复杂度的排序，
 * 计数排序要求输入的数据必须是有确定范围的整数。
 */
public class CountingSortDemo {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 11, 33, 4, 6, 55, 22, 88, 65, 3, 2, 11, 9};
        CountingSort countingSort = new CountingSort();
        System.out.println(Arrays.toString(countingSort.sort(array)));

    }

    public static class CountingSort implements IArraySort {
        @Override
        public int[] sort(int[] sourceArray) {
            // 对 arr 进行拷贝，不改变参数内容
            int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
            int maxValue = getMaxValue(arr);
            return countingSort(arr, maxValue);
        }
        private int[] countingSort(int[] arr, int maxValue) {
            int bucketLen = maxValue + 1;
            int[] bucket = new int[bucketLen];
            for (int value : arr) {
                bucket[value]++;
            }
            int sortedIndex = 0;
            for (int j = 0; j < bucketLen; j++) {
                while (bucket[j] > 0) {
                    arr[sortedIndex++] = j;
                    bucket[j]--;
                }
            }
            return arr;
        }
        private int getMaxValue(int[] arr) {
            int maxValue = arr[0];
            for (int value : arr) {
                if (maxValue < value) {
                    maxValue = value;
                }
            }
            return maxValue;
        }
    }
}
