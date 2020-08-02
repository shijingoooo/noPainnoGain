package com.shijing.nopainnogain.algorithm.listnode;

import java.util.HashMap;
import java.util.Map;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 *
 * @description:
 * @author: shijing
 * @create: 2020-07-27 23:07
 **/
public class RemoveDuplicateNodes {
    public static void main(String[] args) {

    }

    public ListNode remove(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Map<Integer, Object> map = new HashMap<>(16);
        ListNode head0 = head;
        ListNode pre = new ListNode(0, head);

        while (head != null) {
            if (map.containsKey(head.val)) {
                head = head.next;
                pre.next = head;
            } else {
                map.put(head.val, null);
                head = head.next;
                pre = pre.next;
            }
        }

        return head0;
    }
}
