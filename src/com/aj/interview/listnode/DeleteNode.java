package com.aj.interview.listnode;

/**
 * @author aka_after_jason
 * @date 12/3/20
 */

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * 删除链表中的节点
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
