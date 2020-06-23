package com.shijing.nopainnogain.algorithm.dy;

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 * @description:
 * @author: shijing
 * @create: 2020-06-22 22:11
 **/
public class UniquePaths {

    public static void main(String[] args) {

        UniquePaths u = new UniquePaths();

        System.out.println(u.uniquePaths1(7, 3));
        System.out.println(u.uniquePaths2(7, 3));

    }

    /**
     * 空间复杂度 O(m*n)
     */
    public int uniquePaths1(int m, int n) {
        int[][] path = new int[m][n];

        for (int i = 0; i < m; i++) {
            path[i][0] =1;
        }
        for (int i = 0; i < n; i++) {
            path[0][i] =1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }

        return path[m - 1][n - 1];
    }

    /**
     * 空间复杂度 O(n)
     */
    public int uniquePaths2(int m, int n) {
        int[] path = new int[n];

        Arrays.fill(path, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[j] += path[j - 1];
            }
        }

        return path[n - 1];
    }

}
