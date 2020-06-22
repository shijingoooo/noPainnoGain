package com.shijing.nopainnogain.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @description:
 * @author: shijing
 * @create: 2020-06-21 22:58
 **/
public class ThreeSum {
    public static void main(String[] args) {

        ThreeSum t = new ThreeSum();

        int[] a = new int[]{-1, 0, 1, 2, -1, -4};

        List<List<Integer>> list = t.threeSum(a);

        System.out.println(list.toString());


    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            // 需要和上一次枚举的数不相同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            // 数组最右端
            int end = nums.length - 1;

            for (int j = i + 1; j < nums.length - 1; j++) {
                // 需要和上一次枚举的数不相同
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // j 在 end 的左边
                while (j < end && nums[j] + nums[end] > target) {
                    end--;
                }

                // 没找到退出
                if (j == end) {
                    break;
                }

                if (nums[j] + nums[end] == target) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[end]);

                    list.add(result);
                }
            }
        }

        return list;
    }
}
