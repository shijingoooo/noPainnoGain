package com.shijing.nopainnogain.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序（Bubble Sort）也是一种简单直观的排序算法。它重复地走访过要排序的数列，一次比较两个元素，
 * 如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 *
 * 作为最简单的排序算法之一，冒泡排序给我的感觉就像 Abandon 在单词书里出现的感觉一样，每次都在第一页第一位，
 * 所以最熟悉。冒泡排序还有一种优化算法，就是立一个 flag，当在一趟序列遍历中元素没有发生交换，则证明该序列已经有序。
 * 但这种改进对于提升性能来说并没有什么太大作用。
 *
 * 算法步骤
 *
 * 1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 3. 针对所有的元素重复以上的步骤，除了最后一个。
 * 4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
 * 什么时候最快
 * 当输入的数据已经是正序时（都已经是正序了，我还要你冒泡排序有何用啊）。
 *
 * 什么时候最慢
 * 当输入的数据是反序时（写一个 for 循环反序输出数据不就行了，干嘛要用你冒泡排序呢，我是闲的吗）。
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 11, 33, 4, 6, 55, 22, 88, 65, 3, 2, 11, 9};
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println("result: " + Arrays.toString(bubbleSort.sort(array)));

    }

    public static class BubbleSort implements IArraySort {
        @Override
        public int[] sort(int[] sourceArray) {
            // 对 arr 进行拷贝，不改变参数内容
            int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
            for (int i = 1; i < arr.length; i++) {
                // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
                boolean flag = true;
                for (int j = 0; j < arr.length - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                        flag = false;
                    }
                }
                if (flag) {
                    break;
                }
            }
            return arr;
        }
    }

}
