package com.shijing.nopainnogain.algorithm.listnode;

/**
 *
 * 相交链表
 *
 * @description:
 * @author: shijing
 * @create: 2020-07-18 11:10
 **/
public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    public ListNode get(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (headA != null || headB != null) {
            if (headA == headB) {
                return headA;
            }
            if (headA == null) {
                headA = a;
            } else {
                headA = headA.next;
            }

            if (headB == null) {
                headB = b;
            } else {
                headB = headB.next;
            }
        }

        return null;
    }
}
