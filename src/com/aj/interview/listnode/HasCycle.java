package com.aj.interview.listnode;

/**
 * @author aka_after_jason
 * @date 12/3/20
 */

/**
 * 检测链表是否有环
 * 解决思想：通过快慢指针
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return  false;
    }

}
