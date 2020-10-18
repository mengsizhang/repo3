package com.leetcode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class leet24 {
    public ListNode swapPairs(ListNode head) {
        //终止条件，当前没有节点，或者只有一个节点，肯定无需再交换
        if (head == null || head.next == null) {
            return head;
        }
        //将要交换的两个节点
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        //连接后面交换好的子链表
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        //返回每次交换后的链表的头结点，secondNode变成了头结点
        return secondNode;
    }
}
