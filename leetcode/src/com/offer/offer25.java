package com.offer;


/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class offer25 {
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
