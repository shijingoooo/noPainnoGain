package com.shijing.nopainnogain.algorithm.listnode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * @description:
 * @author: shijing
 * @create: 2020-07-22 21:52
 **/
public class DeleteDuplicates {
    public static void main(String[] args) {

    }

    private ListNode delete(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode head0 = head;

        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }

        }

        return head0;
    }
}
