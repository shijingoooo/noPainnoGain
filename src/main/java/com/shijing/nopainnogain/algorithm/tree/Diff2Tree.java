package com.shijing.nopainnogain.algorithm.tree;

/**
 * @program:
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 卡塔兰数
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * @description:
 * @author: shijing
 * @create: 2020-05-12 23:28
 **/
public class Diff2Tree {

    public static void main(String[] args) {
        Diff2Tree diff2Tree = new Diff2Tree();
        System.out.println(diff2Tree.numTrees(4));
    }


    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

}
