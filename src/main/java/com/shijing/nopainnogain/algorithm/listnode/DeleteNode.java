package com.shijing.nopainnogain.algorithm.listnode;

/**
 *
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 * @author: shijing
 * @create: 2020-07-26 22:50
 **/
public class DeleteNode {
    public static void main(String[] args) {

    }

    public ListNode delete(ListNode head, int val) {

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

        ListNode pre = new ListNode(0, head);

        while (head != null) {
            if (head.val == val) {
                head = head.next;
                pre.next = head;
                pre = pre.next;
            } else {
                head = head.next;
                pre = pre.next;
            }
        }

        return head0;

    }

    /**
     * 删除当前节点
     */
    public void delete(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
