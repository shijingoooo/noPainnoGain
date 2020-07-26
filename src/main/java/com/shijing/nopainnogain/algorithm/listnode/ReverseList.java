package com.shijing.nopainnogain.algorithm.listnode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * @author: shijing
 * @create: 2020-07-23 22:43
 **/
public class ReverseList {
    public static void main(String[] args) {

    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        head = head.next;
        pre.next = null;

        while (head != null) {

            ListNode next = head.next;

            head.next = pre;

            pre = head;

            head = next;

        }

        return pre;
    }
}
