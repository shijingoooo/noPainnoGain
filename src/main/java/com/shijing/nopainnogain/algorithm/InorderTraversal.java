package com.shijing.nopainnogain.algorithm;

import java.util.Stack;

/**
 * @description: 给定一个二叉树，返回它的中序遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *  1
 *   \
 *   2
 *  /
 * 3
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * @author: shijing
 * @create: 2020-05-10 22:28
 **/
public class InorderTraversal {

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        Integer[] tree = new Integer[]{1, null, 2, 3};
        System.out.println("--------递归--------");
        inorderTraversal.recursive(0, tree);
        System.out.println("--------迭代--------");
        inorderTraversal.iterate(tree);
    }

    /**
     * 递归算法
     */
    private void recursive(int root, Integer[] tree) {
        if (root > tree.length - 1) {
            return;
        }
        // 递归退出条件
        Integer value = tree[root];
        if (value == null) {
            return;
        }
        // 左子树
        recursive(root + 1, tree);
        // 打印
        System.out.println(value);
        // 右子树
        recursive(root + 2, tree);
    }

    /**
     * 迭代算法
     */
    private void iterate(Integer[] tree) {
        // 存储节点
        Stack<Integer> stack = new Stack<>();
        // 树的节点个数
        int l = tree.length;
        // 数组下标对应树的节点
        int i = 0;
        // 迭代开始
        while (i < l) {
            Integer value = tree[i];
            if (value != null) {
                stack.push(value);
            } else {
                if (!stack.empty()) {
                    System.out.println(stack.pop());
                }
            }
            i++;
        }
        // 输出栈内元素
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}

