package com.shijing.nopainnogain.algorithm.tree;

import java.util.*;

/**
 *
 * @description:
 * @author: shijing
 * @create: 2020-06-09 23:02
 **/
public class LevelOrderBottom {
    public static void main(String[] args) {

        TreeNode ll = new TreeNode(null, null, 5);
        TreeNode left = new TreeNode(ll, null, 2);
        TreeNode rr = new TreeNode(null, null, 4);
        TreeNode right = new TreeNode(null, rr, 3);
        TreeNode treeNode = new TreeNode(left, right, 1);

        LevelOrderBottom l = new LevelOrderBottom();

        List<List<Integer>> lists = l.levelOrderBottom(treeNode);

        int size = lists.size();
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(lists.get(i).toString());
        }

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> start = new ArrayList<>();
        start.add(root);
        List<TreeNode> treeNodes = levelPrint(start, result);

        while (!treeNodes.isEmpty()) {
            treeNodes = levelPrint(treeNodes, result);
        }

        Collections.reverse(result);

        return result;
    }

    public List<TreeNode> levelPrint(List<TreeNode> listNode, List<List<Integer>> result) {

        List<Integer> one = new ArrayList<>();
        List<TreeNode> treeNodeList = new ArrayList<>();

        if (listNode == null || listNode.isEmpty()) {
            return treeNodeList;
        }

        for (TreeNode node : listNode) {
            one.add(node.value);
            if (node.left != null) {
                treeNodeList.add(node.left);
            }
            if (node.right != null) {
                treeNodeList.add(node.right);
            }
        }
        result.add(one);
        return treeNodeList;
    }
}
