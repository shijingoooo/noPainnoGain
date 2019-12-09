package com.shijing.nopainnogain.algorithm.sort;

/**
 * 十种常见排序算法可以分为两大类：
 *
 * 比较类排序：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序。
 *
 * 非比较类排序：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，
 * 因此也称为线性时间非比较类排序。
 *                                      时间复杂度（平均）   时间复杂度（最坏）   时间复杂度（最好）   空间复杂度   稳定性
 *                      冒泡排序            O(n2)               O(n2)            O(n)             O(1)      稳定
 *          交换排序
 *                      快速排序            O(nlog2n)           O(n2)            O(nlog2n)        O(nlog2n) 不稳定
 *
 *                      简单插入排序         O(n2)               O(n2)            O(n2)            O(1)      稳定
 *          插入排序
 *                      希尔排序            O(n1.3)             O(n2)            O(n)             O(1)      不稳定
 * 比较类排序
 *                      简单选择排序         O(n2)               O(n2)            O(n2)            O(1)      不稳定
 *          选择排序
 *                      堆排序             O(nlog2n)           O(nlog2n)         O(nlog2n)        O(1)      不稳定
 *
 *                      二路归并排序
 *          归并排序                        O(nlog2n)           O(nlog2n)        O(nlog2n)         O(n)      稳定
 *                      多路归并排序
 *
 *                      计数排序            O(n+k)              O(n+k)           O(n+k)           O(n+k)     稳定
 * 非比较排序             桶排序             O(n+k)              O(n2)             O(n)             O(n+k)     稳定
 *                      计数排序            O(n*k)              O(n*k)           O(n*k)           O(n+k)     稳定
 *
 * 算法相关概念
 * 稳定：如果a原本在b前面，而a=b，排序之后a仍然在b的前面。
 *
 * 不稳定：如果a原本在b的前面，而a=b，排序之后 a 可能会出现在 b 的后面。
 *
 * 时间复杂度：对排序数据的总的操作次数。反映当n变化时，操作次数呈现什么规律。
 *
 * 空间复杂度：是指算法在计算机内执行时所需存储空间的度量，它也是数据规模n的函数。
 *
 *
 *
 */
public interface IArraySort {
    int[] sort(int[] sourceArray);
}
