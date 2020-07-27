package com.shijing.nopainnogain.algorithm.listnode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author: shijing
 * @create: 2020-07-26 23:01
 **/
public class RemoveElements {

    public static void main(String[] args) {

        ListNode three = new ListNode(3, null);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(3, two);


        RemoveElements r = new RemoveElements();
        r.remove(one, 3);
    }

    public ListNode remove(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        // 找头节点
        ListNode head0 = null;
        while (head != null) {
            if (head.val != val) {
                head0 = head;
                break;
            } else {
                head = head.next;
            }
        }

        head = head0;
        if (head == null) {
            return null;
        }

        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return head0;
    }
}
