package com.shijing.nopainnogain.algorithm.tree;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *  
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * @description:
 * @author: shijing
 * @create: 2020-06-24 22:17
 **/
public class DiameterOfBinaryTree {

    public static void main(String[] args) {

        TreeNode ll = new TreeNode(null, null, 2);
        TreeNode lr = new TreeNode(null, null, 2);
        TreeNode left = new TreeNode(lr, ll, 2);
        TreeNode right = new TreeNode(null, null, 3);
        TreeNode root = new TreeNode(left, right, 1);

        MaxDepth m = new MaxDepth();

        int rl = 0;
        if (root.left != null) {
            rl = m.deep(root.left);
        }

        int rr = 0;
        if (root.right != null) {
            rr = m.deep(root.right);
        }

        System.out.println("直径：" + (rl + rr));
    }


}
