package com.shijing.nopainnogain.algorithm.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * @description:
 * @author: shijing
 * @create: 2020-05-30 20:14
 **/
public class SearchInsert {
    public static void main(String[] args) {

        int[] a = new int[]{1, 3, 5, 6};

        SearchInsert searchInsert = new SearchInsert();

        System.out.println(searchInsert.searchInsert2(a, 5));
        System.out.println(searchInsert.searchInsert2(a, 2));
        System.out.println(searchInsert.searchInsert2(a, 7));
        System.out.println(searchInsert.searchInsert2(a, 0));

    }
    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0] ) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (target == nums[i]) {
                return i;
            }

            if (target < nums[i+1]) {
                return i+1;
            }
        }
        if (target == nums[nums.length - 1]) {
            return nums.length -1;
        } else {
            return nums.length;
        }
    }

    public int searchInsert3(int[] nums, int target) {

        int mid = (nums.length - 1) / 2;

        if (target < nums[mid]) {
            for(int i = 0; i < mid + 1;i++){
                if(nums[i] >= target){
                    return i;
                }
            }
            return mid + 1;
        } else {
            for(int i = mid; i < nums.length;i++){
                if(nums[i] >= target){
                    return i;
                }
            }
            return nums.length;
        }


    }

    public int searchInsert2(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

}
