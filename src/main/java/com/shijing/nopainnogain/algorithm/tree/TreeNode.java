package com.shijing.nopainnogain.algorithm.tree;

/**
 * @description:
 * @author: shijing
 * @create: 2020-05-19 00:26
 **/
public class TreeNode{

    TreeNode left;

    TreeNode right;

    int val;

    public TreeNode(TreeNode left, TreeNode right, int value) {
        this.left = left;
        this.right = right;
        this.val = value;
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
        return val;
    }

    public void setValue(Integer value) {
        this.val = value;
    }
}
