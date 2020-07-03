package com.shijing.nopainnogain.algorithm.array;

/**
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * <p>
 * 形式上，如果可以找出索引 i+1 < j 且满足 A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1] 就可以将数组三等分。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 * <p>
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 * @description:
 * @author: shijing
 * @create: 2020-07-02 21:59
 **/
public class CanThreePartsEqualSum {
    public static void main(String[] args) {

        int a[] = new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        int b[] = new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
        int c[] = new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
        int d[] = new int[]{6, 1, 1, 13, -1, 0, -10, 20};
        int e[] = new int[]{1, -1, 1, -1};


        CanThreePartsEqualSum canThreePartsEqualSum = new CanThreePartsEqualSum();


        //System.out.println(canThreePartsEqualSum.can(a));
        //System.out.println(canThreePartsEqualSum.can(b));
        //System.out.println(canThreePartsEqualSum.can(c));
//        System.out.println(canThreePartsEqualSum.can(d));
        System.out.println(canThreePartsEqualSum.can(e));


    }

    public boolean can(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) {
            // 总和不是3的倍数，直接返回false
            return false;
        }

        // 使用双指针,从数组两头开始一起找，节约时间
        int left = 0;
        int leftSum = A[left];
        int right = A.length - 1;
        int rightSum = A[right];

        // 使用left + 1 < right 的原因，防止只能将数组分成两个部分
        // 例如：[1,-1,1,-1]，使用left < right作为判断条件就会出错
        while (left + 1 < right) {
            if (leftSum == sum / 3 && rightSum == sum / 3) {
                // 左右两边都等于 sum/3 ，中间也一定等于
                return true;
            }
            if (leftSum != sum / 3) {
                // left = 0赋予了初值，应该先left++，在leftSum += A[left];
                leftSum += A[++left];
            }
            if (rightSum != sum / 3) {
                // right = A.length - 1 赋予了初值，应该先right--，在rightSum += A[right];
                rightSum += A[--right];
            }
        }
        return false;
    }
}
