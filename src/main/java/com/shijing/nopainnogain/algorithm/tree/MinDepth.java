package com.shijing.nopainnogain.algorithm.tree;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-07-06 22:31
 **/
public class MinDepth {
    public static void main(String[] args) {

        TreeNode left = new TreeNode(null, null, 2);
        TreeNode right = new TreeNode(null, null, 3);
        TreeNode root = new TreeNode(left, null, 1);

        MinDepth m = new MinDepth();

        System.out.println(m.minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left > 0 && right > 0) {
            return Math.min(left, right) + 1;
        } else if (left > 0 && right == 0) {
            return left + 1;
        } else if (right > 0 && left == 0) {
            return right + 1;
        } else {
            return 1;
        }
    }
}
