package com.shijing.nopainnogain.algorithm.listnode;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * @description:
 * @author: shijing
 * @create: 2020-07-17 22:33
 **/
public class GetKthFromEnd {
    public static void main(String[] args) {

    }

    public ListNode kthFromEnd(ListNode head, int k) {
        ListNode node1 = head;
        ListNode node2 = head;
        for (int i = 0; i < k; i++) {
            node1 = node1.next;
        }

        while (node1 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node2;
    }
}
