package com.shijing.nopainnogain.algorithm.tree;

import java.util.Stack;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:      1          1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * 示例 3:
 * <p>
 * 输入:       1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 *
 * @description:
 * @author: shijing
 * @create: 2020-07-04 08:01
 **/
public class IsSameTree {
    public static void main(String[] args) {
        TreeNode ll = new TreeNode(null, null, 2);
        TreeNode lr = new TreeNode(null, null, 2);
        TreeNode left = new TreeNode(null, null, 2);
        TreeNode right = new TreeNode(null, null, 3);
        TreeNode root1 = new TreeNode(ll, null, 1);
        TreeNode root2 = new TreeNode(null, lr, 1);

        IsSameTree i = new IsSameTree();

        System.out.println(i.isSame(root1, root2));
    }

    public boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return (isSame(p.left, q.left) && isSame(p.right, q.right));
    }
}
