package com.shijing.nopainnogain.algorithm.tree;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * @description:
 * @author: shijing
 * @create: 2020-05-19 00:25
 **/
public class MaxDepth {

    public static void main(String[] args) {

        TreeNode left = new TreeNode(null, null, 2);
        TreeNode right = new TreeNode(null, null, 3);
        TreeNode root = new TreeNode(left, null, 1);

        MaxDepth maxDepth = new MaxDepth();

        int max = maxDepth.deep(root);
        String a = "1";
        a.intern();
        System.out.println("deep: " + max);
    }

    public int deep(TreeNode treeNode) {

        if (treeNode == null) {
            return 0;
        }

        int left = deep(treeNode.getLeft());
        int right = deep(treeNode.getRight());

        return Math.max(left, right) + 1;

    }

}
