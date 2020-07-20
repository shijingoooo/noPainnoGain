package com.shijing.nopainnogain.algorithm.listnode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * @description:
 * @author: shijing
 * @create: 2020-07-19 09:18
 **/
public class ReversePrint {
    public static void main(String[] args) {

        ListNode three = new ListNode(2, null);
        ListNode two = new ListNode(3, three);
        ListNode one = new ListNode(1, two);

        ReversePrint r = new ReversePrint();
        System.out.println(Arrays.toString(r.r(one)));

    }

    public int[] r(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}
