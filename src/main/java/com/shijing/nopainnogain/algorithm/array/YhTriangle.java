package com.shijing.nopainnogain.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * @description:
 * @author: shijing
 * @create: 2020-06-01 23:20
 **/
public class YhTriangle {
    public static void main(String[] args) {
        YhTriangle y = new YhTriangle();
        int row = 10;
        List<List<Integer>> generate = y.generate(row);

        System.out.println("杨辉三角：" + row + "行");

        for (List<Integer> list : generate) {
            for (int i = row; i > list.size(); i--) {
                System.out.print(" ");
            }
            System.out.println(list.toString());
        }

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);

        if (numRows <= 0) {
            return result;
        }

        List<Integer> one = new ArrayList<>();
        one.add(1);
        result.add(one);
        if (numRows == 1) {
            return result;
        }

        List<Integer> two = new ArrayList<>();
        two.add(1);
        two.add(1);
        result.add(two);
        if (numRows == 2) {
            return result;
        }

        for (int i = 2; i < numRows; i++) {
            nextRow(result, i);
        }

        return result;
    }

    public void nextRow(List<List<Integer>> result, int length) {
        List<Integer> one = new ArrayList<>(length + 1);
        // 头
        one.add(1);
        // 中间
        List<Integer> list = result.get(length - 1);
        for (int i = 0; i < length + 1 - 2; i++) {
            one.add(list.get(i) + list.get(i + 1));
        }
        // 尾
        one.add(1);

        result.add(one);
    }
}
