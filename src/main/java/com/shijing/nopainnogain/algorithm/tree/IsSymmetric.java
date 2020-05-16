package com.shijing.nopainnogain.algorithm.tree;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * https://leetcode-cn.com/problems/symmetric-tree
 *
 * @description:
 * @author: shijing
 * @create: 2020-05-14 22:10
 **/

class TreeNode{

    TreeNode left;

    TreeNode right;

    Integer value;

    public TreeNode(TreeNode left, TreeNode right, Integer value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}


public class IsSymmetric {

    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();

        TreeNode left = new TreeNode(null, null, 2);
        TreeNode right = new TreeNode(null, null, 3);
        TreeNode treeNode = new TreeNode(left, null, 1);

        System.out.println("对称二叉树：" + isSymmetric.isMirror(treeNode.left, treeNode.right));

    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        return (t1.value.equals(t2.value)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left));

    }


}
