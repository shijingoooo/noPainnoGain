package com.shijing.nopainnogain.algorithm.tree;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * @description:
 * @author: shijing
 * @create: 2020-07-10 21:35
 **/
public class IsBalanced {

    private MaxDepth maxDepth = new MaxDepth();

    public static void main(String[] args) {
        IsBalanced i = new IsBalanced();

        TreeNode ll = new TreeNode(null, null, 2);
        TreeNode left = new TreeNode(ll, null, 2);
        TreeNode right = new TreeNode(null, null, 3);
        TreeNode root = new TreeNode(left, null, 1);

        System.out.println(i.isBalanced(root));

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int ldeep = maxDepth.deep(root.left);
        int rdeep = maxDepth.deep(root.right);

        return Math.abs(ldeep - rdeep) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
}
