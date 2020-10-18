package com.leetcode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class leet21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode preNode = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                preNode.next = l1;
                preNode = preNode.next;
                l1 = l1.next;
            } else {
                preNode.next = l2;
                preNode = preNode.next;
                l2 = l2.next;
            }
        }
        preNode.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}

