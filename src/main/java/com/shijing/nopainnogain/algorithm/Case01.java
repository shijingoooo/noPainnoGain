package com.shijing.nopainnogain.algorithm;

import java.util.*;

public class Case01 {
    /**
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素
     * 示例:
     * 输入:
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     * <p>
     * 这道题目看上去虽然没有涉及复杂的数据结构或者高级的算法，但实际在写代码的过程中会包含多个循环，需要判断多个边界条件，
     * 并且在写之前从思维层面一定要先考虑清楚，形成清晰思路，避免出现做题时“一看就会，一写就废”的情况。
     * 这道题的核心思想是，由起点坐标、方向、位移可以定义矩阵中的唯一一条线段，并且可知当前路径下的所有坐标；
     * 而螺旋的过程可以抽象为访问多条首尾相连的线段，并且这些线段有如下特征：
     * 起点坐标可知：因为多条路线首尾相连，所以下一个线段的起点为上一个线段的尾巴。
     * 方向可知：总是按照向右、 向下、 向左、 向上循环切换。
     * 位移可知：横向位移为矩阵的宽度、纵向位移为矩阵的高度，并且总是可以根据当前线段的方向，修正之后矩阵的参数。
     * 横向：高度 -1
     * 纵向：宽度 -1
     * 总位移与矩阵的面积相等。
     * 通过这些抽象条件，我们可以根据初始起点坐标、方向、位移，螺旋得到矩阵中所有坐标。
     *
     * 复杂度分析：
     * 时间复杂度：O(N^2)，其中 N 是输入矩阵所有元素的个数。
     * 空间复杂度：O(N)，存储结果集 result。
     *
     * @param matrix 矩阵
     * @return 结果
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        int height = matrix.length, width = height == 0 ? 0 : matrix[0].length;
        int size = height * width;

        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};

        // 初始化起点坐标:(0,-1) 方向:向右;
        int x = 0, y = -1, dir = 0;
        for (int step, total = 0; total < size; total += step) {

            // 根据方向得到对应的位移, 并修正此后矩阵的参数(此后线段的长度)
            if (dir == 0 || dir == 2) {
                step = width;
                height--;
            } else {
                step = height;
                width--;
            }
            // 此前确定了起点坐标、方向和位移, 就可以得到当前线段的所有坐标,并输出到结果集;
            for (int i = step; i > 0; i--) {
                x += dirX[dir];
                y += dirY[dir];
                result.add(matrix[x][y]);
            }
            // 调整下一条线段方向
            dir = ++dir % 4;
        }

        return result;
    }

    /**
     * 实现一个基本的计算器来计算一个简单的字符串表达式的值。字符串表达式仅包含非负整数，“+， - ，*，/” 四种运算符和空格。整数除法仅保留整数部分。
     * 示例 1:
     * 输入: "3+2*2"
     * 输出: 7
     *
     * 这道题由于存在运算优先级，首先可以想到使用一个栈来保存数字，如果数字之前的符号是加或减，那么就把当前数字压入栈中；
     * 如果之前的符号是乘或除，那么就从栈顶取出一个数字和当前数字进行乘或除的运算，再把结果压入栈中。这里需要注意，
     * 减法是通过加入当前数字的相反数来实现。这样完成一遍遍历后，所有的乘或除都运算完了，再把栈中所有的数字都加起来就是最终结果了。
     *
     * 复杂度分析：
     * 时间复杂度：O(N)，其中 N 是输入矩阵所有元素的个数。
     * 空间复杂度：O(N)，主要是栈占用的容量。
     *
     * @param s 输入字符串
     * @return 结果
     */
    public long calculate(String s) {
        // 有个测试用例 int 型会超范围
        long n = s.length(), num = 0, result = 0;
        // 假设第一个运算符为+，即第一个数直接入栈
        char op = '+';
        Stack<Long> nums = new Stack<>();

        for (int i = 0; i < n; ++i) {
            // 是数字
            if (s.charAt(i) >= '0') {
                num = num * 10 + s.charAt(i) - '0';
            }
            // 是运算符或最后一个数字
            if ((s.charAt(i) < '0' && s.charAt(i) != ' ') || i == n - 1) {
                if (op == '+') nums.push(num);
                if (op == '-') nums.push(-num);
                if (op == '*' || op == '/') {
                    long temp = (op == '*') ? nums.pop() * num : nums.pop() / num;
                    nums.push(temp);
                }
                op = s.charAt(i);
                num = 0;
            }
        }

        // 计算结果
        while (!nums.empty()) {
            result += nums.pop();
        }
        return result;
    }

    /**
     * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     *
     * 这题的解题思路在于，对于所有数字来说，只分为奇数和偶数，关键是在二进制数中找到奇数和偶数的区别。
     * 对于二进制数来说，奇数一定比它前一个偶数多一个最低位的 1；而偶数中 1 的个数一定和它除以 2 的数是一样多的，因为最低位都是 0。
     *
     * @param num 正整数
     * @return 结果
     */
    public String countBits(int num) {
        int[] res = new int[num + 1];
        res[0] =  0;
        int n = num % 2 == 1 ? num - 1 : num;
        for(int i = 1;i <= n;i++) {
            res[i] = res[i-1] + 1;
            i++;
            res[i] = res[i / 2];
        }
        if(num % 2 == 1)
            res[num] = res[n] + 1;
        return Arrays.toString(res);
    }

    public static void main(String[] args) {
        Case01 case01 = new Case01();
        int[][] a = {{1,2,3},{4,5,6}};
        List<Integer> result0 = case01.spiralOrder(a);
        System.out.println("1: " + result0.toString());
        System.out.println("--------------");

        String s = "1+2*3+3/3*2";
        long result1 = case01.calculate(s);
        System.out.println("2: " + result1);
        System.out.println("--------------");

        String result3 = case01.countBits(5);
        System.out.println("3: " + result3);

        System.out.println("--------------");
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
