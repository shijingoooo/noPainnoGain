package com.shijing.nopainnogain.algorithm.listnode;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-07-14 21:55
 **/
public class Mock {
    public ListNode toListNode(int[] array) {
        ListNode head = new ListNode(array[0]);
        ListNode tail = head;
        for (int i = 1; i < array.length; i++) {
            ListNode next = new ListNode(array[i]);
            tail.next = next;
            tail = next;
        }

        return head;
    }
}
