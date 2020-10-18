package com.leetcode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class leet19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode preNode = head;
        int count = 1;
        while (preNode != null) {
            len++;
            preNode = preNode.next;
        }
        if (n == len) {
            return head.next;
        }
        preNode = head;
        ListNode curNode = head.next;
        while (curNode != null) {
            if (count == len - n) {
                preNode.next = curNode.next;
                break;
            }
            count++;
            preNode = preNode.next;
            curNode = curNode.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

