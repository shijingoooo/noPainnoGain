package com.shijing.nopainnogain.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description:
 * @author: shijing
 * @create: 2020-06-11 22:06
 **/
public class TwoSum {
    public static void main(String[] args) {

        int[] a = new int[]{2, 7, 11, 15};

        TwoSum t = new TwoSum();
        System.out.println(Arrays.toString(t.twoSum(a, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[]{0, 0};
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            if (map.containsKey(b)) {
                return new int[]{map.get(b), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{0, 0};
    }
}
