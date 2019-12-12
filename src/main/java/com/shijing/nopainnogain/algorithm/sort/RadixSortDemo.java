package com.shijing.nopainnogain.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较。
 * 由于整数也可以表达字符串（比如名字或日期）和特定格式的浮点数，所以基数排序也不是只能使用于整数。
 *
 *
 * 1）基数排序 vs 计数排序 vs 桶排序
 *
 * 基数排序有两种方法：
 *
 * 这三种排序算法都利用了桶的概念，但对桶的使用方法上有明显差异：
 *
 * 基数排序：根据键值的每位数字来分配桶；
 *
 * 计数排序：每个桶只存储单一键值；
 *
 * 桶排序：每个桶存储一定范围的数值；
 */
public class RadixSortDemo {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 11, 33, 4, 6, 55, 22, 88, 65, 3, 2, 11, 9};
        RadixSort radixSort = new RadixSort();
        System.out.println(Arrays.toString(radixSort.sort(array)));

    }

    /**
     * 基数排序
     * 考虑负数的情况还可以参考： https://code.i-harness.com/zh-CN/q/e98fa9
     */
    public static class RadixSort implements IArraySort {
        @Override
        public int[] sort(int[] sourceArray) {
            // 对 arr 进行拷贝，不改变参数内容
            int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
            int maxDigit = getMaxDigit(arr);
            return radixSort(arr, maxDigit);
        }
        /**
         * 获取最高位数
         */
        private int getMaxDigit(int[] arr) {
            int maxValue = getMaxValue(arr);
            return getNumLenght(maxValue);
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
        protected int getNumLenght(long num) {
            if (num == 0) {
                return 1;
            }
            int lenght = 0;
            for (long temp = num; temp != 0; temp /= 10) {
                lenght++;
            }
            return lenght;
        }
        private int[] radixSort(int[] arr, int maxDigit) {
            int mod = 10;
            int dev = 1;
            for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
                // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
                int[][] counter = new int[mod * 2][0];
                for (int j = 0; j < arr.length; j++) {
                    int bucket = ((arr[j] % mod) / dev) + mod;
                    counter[bucket] = arrayAppend(counter[bucket], arr[j]);
                }
                int pos = 0;
                for (int[] bucket : counter) {
                    for (int value : bucket) {
                        arr[pos++] = value;
                    }
                }
            }
            return arr;
        }
        /**
         * 自动扩容，并保存数据
         *
         * @param arr
         * @param value
         */
        private int[] arrayAppend(int[] arr, int value) {
            arr = Arrays.copyOf(arr, arr.length + 1);
            arr[arr.length - 1] = value;
            return arr;
        }
    }
}
