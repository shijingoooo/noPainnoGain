package com.shijing.nopainnogain.algorithm.listnode;

/**
 * @program:
 * @description:
 * @author: shijing
 * @create: 2020-07-14 21:54
 **/
public class MergeTwoLists {
    public static void main(String[] args) {
        Mock mock = new Mock();
        int[] a = new int[]{1, 2, 4};
        int[] b = new int[]{1, 3, 4};
        int[] c = new int[]{2};
        int[] d = new int[]{1};
        int[] e = new int[]{-9, 3};
        int[] f = new int[]{5, 7};
        ListNode nodea = mock.toListNode(e);
        ListNode nodeb = mock.toListNode(f);

        MergeTwoLists m = new MergeTwoLists();

        ListNode result = m.merge(nodea, nodeb);

        result.print();

    }

    public ListNode merge0(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0, l1);
        ListNode next = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                next.next = l1;
                l1 = l1.next;
            } else {
                next.next = l2;
                l2 = l2.next;
            }

            next = next.next;
        }

        next.next = l1 == null ? l2 : l1;

        return head.next;
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0, l1);
        ListNode cur = new ListNode(0, l1);
        ListNode other = l2;
        if (l2.val < l1.val) {
            result = new ListNode(0, l2);
            cur = new ListNode(0, l2);
            other = l1;
        }

        ListNode prev = new ListNode(0, cur);


        while (cur.next != null) {
            if (other == null) {
                break;
            }
            if (cur.next.val > other.val) {
                ListNode temp2 = other.next;
                after(prev.next, other);
                prev.next = prev.next.next;
                other = temp2;
            } else {
                prev.next = prev.next.next;
                cur.next = cur.next.next;
            }
        }

        if (other != null) {
            after(prev.next, other);
        }

        return result.next;

    }

    public void after(ListNode node1, ListNode node2) {
        ListNode temp = node1.next;
        if (temp != null) {
            node1.next = node2;
            node2.next = temp;
        } else {
            node1.next = node2;
        }
    }

}
