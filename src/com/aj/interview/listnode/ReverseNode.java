package com.aj.interview.listnode;

/**
 * @author aka_after_jason
 * @date 12/3/20
 */

import com.aj.datastructrure.list.list.List;

/**
 * 反转链表：
 * 两种方式：
 * 1.递归方式反转
 * 2.非递归方式反转（头插法）
 */
public class ReverseNode {

    // 1.递归法
    public ListNode reverseList(ListNode head) {
        // 如果头节点为空 或者 只有一个节点 都直接返回 不需要反转
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // 非递归法反转（头插法）
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            head = tmp;
        }
        return newHead;
    }
}
