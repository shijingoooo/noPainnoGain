package com.shijing.nopainnogain.algorithm.array;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 *  
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @description:
 * @author: shijing
 * @create: 2020-06-14 21:04
 **/
public class FindMedianInSortedArrays {
    public static void main(String[] args) {
        FindMedianInSortedArrays f = new FindMedianInSortedArrays();
        int[] a1 = new int[]{1, 3};
        int[] a2 = new int[]{2};

//        System.out.println(f.find(a1, a2));

        int[] b1 = new int[]{1, 2};
        int[] b2 = new int[]{3, 4};

//        System.out.println(f.find(b1, b2));

        int[] c1 = new int[]{2, 3, 4};
        int[] c2 = new int[]{1};

        System.out.println(f.find(c1, c2));

        int[] d1 = new int[]{0};
        int[] d2 = new int[]{1};

//        System.out.println(f.find(d1, d2));

        int[] e1 = new int[]{3};
        int[] e2 = new int[]{-2, -1};

//        System.out.println(f.find(e1, e2));

        int[] f1 = new int[]{1, 2};
        int[] f2 = new int[]{-1, 3};

//        System.out.println(f.find(f1, f2));

        int[] g1 = new int[]{1, 2, 2};
        int[] g2 = new int[]{1, 2, 3};

//        System.out.println(f.find(g1, g2));

        int[] h1 = new int[]{};
        int[] h2 = new int[]{1, 2, 3, 4, 5, 6};

//        System.out.println(f.find(h1, h2));

        int[] i1 = new int[]{1};
        int[] i2 = new int[]{2, 3, 4};

//        System.out.println(f.find(i2, i1));

        int[] j1 = new int[]{1, 2};
        int[] j2 = new int[]{1, 2, 3};

//        System.out.println(f.find(j1, j2));
    }

    public double find(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int total = l1 + l2;
        int mid = (total + 1) / 2;

        boolean isOdd = total % 2 == 1;

        if (l1 == 0 && l2 > 0) {
            return mid(nums2, mid, isOdd);
        }

        if (l2 == 0 && l1 > 0) {
            return mid(nums1, mid, isOdd);
        }

        if (nums1[l1 - 1] < nums2[0]) {
            if (l1 - l2 == 0) {
                return (nums1[l1 - 1] + nums2[0]) / 2.0;
            }
            if (l1 - l2 == 1) {
                return nums1[l1 - 1];
            }
            if (l2 - l1 == 1) {
                return nums2[0];
            }
        } else if (nums1[0] >= nums2[l2 -1]){
            if (l1 - l2 == 0) {
                return (nums2[l2 - 1] + nums1[0]) / 2.0;
            }
            if (l2 - l1 == 1) {
                return nums2[l2 - 1];
            }
            if (l1 - l2 == 1) {
                return nums1[0];
            }
        }

        int i = 0;
        int n = 0;
        int m = 0;
        int[] result = new int[]{0, 0};
        while (i < mid) {
            if (n == l1) {
                result[0] = nums2[m++];
                result[1] = nums2[m];
                i++;
                continue;
            }

            if (m == l2) {
                result[0] = nums1[n++];
                result[1] = nums1[n];
                i++;
                continue;
            }

            if (nums1[n] <= nums2[m]) {
                result[0] = nums1[n++];
                if (n < l1) {
                    result[1] = nums1[n] <= nums2[m] ? nums1[n] : nums2[m];
                } else {
                    result[1] = nums2[m];
                }
            } else {
                result[0] = nums2[m++];
                if (m < l2) {
                    result[1] = nums1[n] <= nums2[m] ? nums1[n] : nums2[m];
                } else {
                    result[1] = nums1[n];
                }
            }

            i++;
        }

        if (isOdd) {
            return result[0];
        } else
            return (result[0] + result[1]) / 2.0;

    }

    private double mid(int[] nums, int mid, boolean isOdd) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (isOdd) {
            return nums[mid - 1];
        } else
            return (nums[mid - 1] + nums[mid]) / 2.0;
    }
}
