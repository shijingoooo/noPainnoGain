package com.shijing.nopainnogain.algorithm.dy;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *
 * 动态规划
 * 考虑所有可能的抢劫方案过于困难。一个自然而然的想法是首先从最简单的情况开始。记：
 * f(k) = 从前 k 个房屋中能抢劫到的最大数额，Ai = 第 i 个房屋的钱数。
 * 首先看 n = 1 的情况，显然 f(1) = A1
 * 再看 n = 2，f(2) = max(A1, A2)
 * 对于 n = 3，有两个选项:
 * 抢第三个房子，将数额与第一个房子相加。
 * 不抢第三个房子，保持现有最大数额。
 * 显然，你想选择数额更大的选项。于是，可以总结出公式：
 * f(k) = max(f(k – 2) + Ak, f(k – 1))
 *
 * @description:
 * @author: shijing
 * @create: 2020-05-17 22:39
 **/
public class Rob {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 1};
        int[] b = new int[]{2, 7, 9, 3, 1};

        Rob rob = new Rob();
        System.out.println("a[] max: " + rob.rob(a));
        System.out.println("b[] max: " + rob.rob(b));
    }

    public int rob(int[] a) {
        int pre = 0;
        int max = 0;

        for (int i : a) {
            int temp = max;
            max = Math.max(pre + i, max);
            pre = temp;
        }

        return max;
    }

}
