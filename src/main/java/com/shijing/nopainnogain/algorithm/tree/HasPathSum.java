package com.shijing.nopainnogain.algorithm.tree;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * @description:
 * @author: shijing
 * @create: 2020-06-29 21:50
 **/
public class HasPathSum {

    public static void main(String[] args) {

        TreeNode ll = new TreeNode(null, null, 2);
        TreeNode lr = new TreeNode(null, null, 2);
        TreeNode left = new TreeNode(lr, ll, 2);
        TreeNode right = new TreeNode(null, null, 3);
        TreeNode root = new TreeNode(left, right, 1);

        HasPathSum h = new HasPathSum();

        System.out.println(h.hasPathSum(root, 0));

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum = sum - root.value;

        if (root.right == null && root.left == null) {
            return sum == 0;
        }

        boolean right = hasPathSum(root.right, sum);
        boolean left = hasPathSum(root.left, sum);

        return right || left;

    }
}
